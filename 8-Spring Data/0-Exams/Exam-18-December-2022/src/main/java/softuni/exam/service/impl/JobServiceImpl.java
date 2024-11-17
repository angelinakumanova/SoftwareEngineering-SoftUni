package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.JobService;

import java.io.IOException;

@Service
public class JobServiceImpl implements JobService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readJobsFileContent() throws IOException {
        return "";
    }

    @Override
    public String importJobs() throws IOException {
        return "";
    }

    @Override
    public String getBestJobs() {
        return "";
    }
}
