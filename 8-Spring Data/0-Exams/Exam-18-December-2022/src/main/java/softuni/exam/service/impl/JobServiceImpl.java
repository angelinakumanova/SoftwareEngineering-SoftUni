package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JobExportDto;
import softuni.exam.models.dto.JobImportDto;
import softuni.exam.models.dto.JobListImportDto;
import softuni.exam.models.entity.Job;
import softuni.exam.repository.JobRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.service.JobService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final static String JOBS_PATH = "src/main/resources/files/xml/jobs.xml";

    private final JobRepository jobRepository;
    private final CompanyService companyService;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public JobServiceImpl(JobRepository jobRepository, CompanyService companyService, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.jobRepository = jobRepository;
        this.companyService = companyService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.jobRepository.count() > 0;
    }

    @Override
    public String readJobsFileContent() throws IOException {
        return Files.readString(Path.of(JOBS_PATH));
    }

    @Override
    public String importJobs() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(JOBS_PATH, JobListImportDto.class).getJobs()
                .stream()
                .filter(j -> isValidJob(j, sb))
                .map(this::mapToJob)
                .forEach(job -> saveJob(job, sb));

        jobRepository.flush();
        return sb.toString();
    }

    private void saveJob(Job job, StringBuilder sb) {
        String formatted = String.format("Successfully imported job %s", job.getTitle());
        sb.append(formatted).append(System.lineSeparator());

        jobRepository.save(job);
    }

    private Job mapToJob(JobImportDto j) {
        Job map = modelMapper.map(j, Job.class);
        map.setCompany(companyService.findById(j.getCompanyId()).get());

        return map;
    }

    private boolean isValidJob(JobImportDto j, StringBuilder sb) {
        if (!validationUtil.isValid(j) || companyService.findById(j.getCompanyId()).isEmpty()) {
            sb.append("Invalid job").append(System.lineSeparator());
            return false;
        }

        return true;
    }

    @Override
    public String getBestJobs() {
        StringBuilder sb = new StringBuilder();
        
        jobRepository.findBySalaryGreaterThanEqualAndHoursAWeekLessThanEqualOrderBySalaryDesc(5000.0, 30.0)
                .stream()
                .map(j -> modelMapper.map(j, JobExportDto.class))
                .forEach(job -> {
                    //Job title {jobTitle}
                    //-Salary: {jobSalary}$¬¬
                    //      --Hours a week: {hoursAWeek}h.
                    String formatted = String.format("Job title %s%n" +
                            "-Salary: %.2f$%n" +
                            "--Hours a week: %.2f", job.getTitle(), job.getSalary(), job.getHoursAWeek());

                    sb.append(formatted).append(System.lineSeparator());
                });
        return sb.toString();
    }
}
