package bg.softuni.json_processing.controller;

import bg.softuni.json_processing.service.CategoryService;
import bg.softuni.json_processing.service.ProductService;
import bg.softuni.json_processing.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsoleLineRunner implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public ConsoleLineRunner(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
        
        String productsJsonByPriceRange = productService.getProductsJsonByPriceRange(500, 1000);
        System.out.println(productsJsonByPriceRange);
    }

    private void seedDatabase() throws IOException {
        if (!userService.isImported()) {
            userService.seedUsers();
        }

        if (!categoryService.isImported()) {
            categoryService.seedCategories();
        }

        if (!productService.isImported()) {
            productService.seedProducts();
        }
    }
}
