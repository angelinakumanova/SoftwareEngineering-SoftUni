package bg.softuni.json_processing.service;

import java.io.IOException;

public interface UserService {

    void seedUsers() throws IOException;

    boolean isImported();

}
