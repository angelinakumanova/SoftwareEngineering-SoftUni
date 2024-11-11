package bg.softuni.json_processing.controller;

import bg.softuni.json_processing.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLineRunner implements CommandLineRunner {
    private final UserService userService;

    public ConsoleLineRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userService.isImported()) {
            userService.seedUsers();
        }
    }
}
