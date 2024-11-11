package bg.softuni.json_processing.controller;

import bg.softuni.json_processing.service.CategoryService;
import bg.softuni.json_processing.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLineRunner implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;

    public ConsoleLineRunner(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userService.isImported()) {
            userService.seedUsers();
        }

        if (!categoryService.isImported()) {
            categoryService.seedCategories();
        }
    }
}
