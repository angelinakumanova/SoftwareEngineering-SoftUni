package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public boolean isImported() {
        return false;
    }

    @Override
    public String readFile() throws IOException {
        return "";
    }

    @Override
    public void seedData() throws JAXBException {

    }
}
