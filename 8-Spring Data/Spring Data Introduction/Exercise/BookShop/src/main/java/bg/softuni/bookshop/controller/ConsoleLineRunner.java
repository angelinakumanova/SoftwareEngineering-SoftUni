package bg.softuni.bookshop.controller;

import bg.softuni.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;

    @Autowired
    public ConsoleLineRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        if (!categoryService.areImported()) {
            categoryService.seedCategories();
        }
    }
}
