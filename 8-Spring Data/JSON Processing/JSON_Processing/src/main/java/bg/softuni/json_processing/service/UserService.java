package bg.softuni.json_processing.service;

import bg.softuni.json_processing.data.entities.User;

import java.io.IOException;

public interface UserService {

    void seedUsers() throws IOException;

    boolean isImported();

    User getRandomUser();

    void getUserJsonWithSoldProducts();

}
