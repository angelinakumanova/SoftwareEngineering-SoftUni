package bg.softuni.usersystem.controller;

import bg.softuni.usersystem.service.TownService;
import bg.softuni.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final UserService userService;
    private final TownService townService;

    @Autowired
    public ConsoleLineRunner(UserService userService, TownService townService) {
        this.userService = userService;
        this.townService = townService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedDatabase();

//        userService.getUsersByEmailProvider("gmail.com");
//        userService.removeInactiveUsersAfterGivenTime(LocalDateTime.of(2018, 1, 1, 0, 0, 0));
    }

    private void seedDatabase() throws IOException {
        if (!townService.isImported()) {
            townService.seedTowns();
        }

        if (!userService.isImported()) {
            userService.seedUsers();
        }
    }
}
