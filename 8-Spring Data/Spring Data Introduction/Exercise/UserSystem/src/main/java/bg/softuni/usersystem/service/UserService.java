package bg.softuni.usersystem.service;


import java.io.IOException;

public interface UserService {
    void seedUsers() throws IOException;

    boolean isImported();

    void getUsersByEmailProvider(String emailProvider);
}
