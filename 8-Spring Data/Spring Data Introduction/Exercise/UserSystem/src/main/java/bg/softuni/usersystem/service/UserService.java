package bg.softuni.usersystem.service;


import java.io.IOException;
import java.time.LocalDateTime;

public interface UserService {
    void seedUsers() throws IOException;

    boolean isImported();

    void getUsersByEmailProvider(String emailProvider);

    void removeInactiveUsersAfterGivenTime(LocalDateTime dateTime);
}
