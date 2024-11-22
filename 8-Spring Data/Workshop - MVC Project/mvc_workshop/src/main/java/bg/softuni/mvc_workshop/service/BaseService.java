package bg.softuni.mvc_workshop.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface BaseService {
    boolean isImported();

    String readFile() throws IOException;

    void seedData() throws JAXBException;
}
