package bg.softuni.bookshop.service;

import java.io.IOException;

public interface BookService {
    void seedBooks() throws IOException;

    boolean isImported();

    void findAllBooksAfter2000();

    void getBooksByAuthor(String firstName, String lastName);
}
