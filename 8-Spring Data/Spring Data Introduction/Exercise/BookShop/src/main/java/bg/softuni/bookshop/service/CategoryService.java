package bg.softuni.bookshop.service;

import bg.softuni.bookshop.data.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    boolean isImported();

    Set<Category> getRandomCategories();
}
