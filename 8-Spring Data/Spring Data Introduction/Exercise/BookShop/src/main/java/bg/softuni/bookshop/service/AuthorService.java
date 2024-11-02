package bg.softuni.bookshop.service;

import bg.softuni.bookshop.data.entities.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;

    boolean isImported();

    Author getRandomAuthor();

    void printAllAuthorsWithBooksBefore1990();

    void printAllAuthorsByNumberOfBooks();
}
