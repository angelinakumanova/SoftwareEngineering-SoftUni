package bg.softuni.usersystem.controller;

import bg.softuni.usersystem.service.TownService;
import bg.softuni.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

        userService.getUsersByEmailProvider("gmail.com");
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
