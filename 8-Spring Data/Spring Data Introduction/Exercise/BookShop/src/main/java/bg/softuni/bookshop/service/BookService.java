package bg.softuni.bookshop.service;

import java.io.IOException;

public interface BookService {
    void seedBooks() throws IOException;

    boolean isImported();
}
