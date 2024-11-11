package bg.softuni.json_processing.service;

import bg.softuni.json_processing.data.entities.Category;

import java.util.Set;

public interface CategoryService {
    void seedCategories();

    boolean isImported();

    Set<Category> getRandomCategories();

    void getJsonCategoriesProductsCount();
}
