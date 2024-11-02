package bg.softuni.bookshop.controller;

import bg.softuni.bookshop.service.AuthorService;
import bg.softuni.bookshop.service.BookService;
import bg.softuni.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public ConsoleLineRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedDatabase();

        bookService.findAllBooksAfter2000();
        authorService.printAllAuthorsWithBooksBefore1990();
        authorService.printAllAuthorsByNumberOfBooks();
    }

    private void seedDatabase() throws IOException {
        if (!categoryService.isImported()) {
            categoryService.seedCategories();
        }
        if (!authorService.isImported()) {
            authorService.seedAuthors();
        }

        if (!bookService.isImported()) {
            bookService.seedBooks();
        }
    }
}
