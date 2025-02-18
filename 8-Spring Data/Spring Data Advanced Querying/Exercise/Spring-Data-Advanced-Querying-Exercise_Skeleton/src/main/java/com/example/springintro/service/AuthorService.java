package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    void printAuthorsWithEndingPrefix(String prefix);

    void printAuthorCopies(String authorName);

    void printAuthorTotalBooks(String authorName);
}
