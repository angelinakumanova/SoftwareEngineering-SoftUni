package bg.softuni.mvc_workshop.service;

import java.io.IOException;

public interface BaseService {
    boolean isImported();

    String readFile() throws IOException;
}
