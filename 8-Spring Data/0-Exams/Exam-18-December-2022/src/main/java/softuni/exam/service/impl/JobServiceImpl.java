package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JobListImportDto;
import softuni.exam.models.entity.Job;
import softuni.exam.repository.JobRepository;
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

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public JobServiceImpl(JobRepository jobRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.jobRepository = jobRepository;
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

        List<JobListImportDto> jobs = xmlParser.fromFile(JOBS_PATH, JobListImportDto.class).getJobs();

        System.out.println();
        return "";
    }

    @Override
    public String getBestJobs() {
        return "";
    }
}
