package com.example.springintro.service;

import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    void printBooksTitlesByAgeRestriction(String ageRestriction);

    void printGoldenBooksWithLessThanCopies(int copies);

    void printBooksByPrice(double lowerThanPrice, double higherThanPrice);

    void printUnreleasedBooksInYear(int year);

    void printBooksReleasedBeforeDate(String date);

    void printBooksByTitleContaining(String title);

    void printBooksByAuthorNamePrefix(String authorName);

    int getBooksCountByTitleLength(int number);

    void printBookInfoByTitle(String title);

    void increaseBookCopiesAfterDate(String date, int copies);
}
