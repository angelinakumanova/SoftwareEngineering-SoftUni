package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "jobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobListImportDto {
    @XmlElement(name = "job")
    private List<JobListImportDto> jobs;

    public  JobListImportDto() {}

    public List<JobListImportDto> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobListImportDto> jobs) {
        this.jobs = jobs;
    }
}
