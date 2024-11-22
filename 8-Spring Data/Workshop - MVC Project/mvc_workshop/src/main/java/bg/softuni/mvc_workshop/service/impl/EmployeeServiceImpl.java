package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
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
