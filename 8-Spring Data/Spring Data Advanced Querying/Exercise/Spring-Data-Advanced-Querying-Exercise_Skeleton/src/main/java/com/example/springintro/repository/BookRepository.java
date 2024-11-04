package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    @Query("SELECT b FROM Book b WHERE b.ageRestriction = :ageRestriction")
    Set<Book> getBooksByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b FROM Book b WHERE b.editionType = :editionType AND b.copies < :copies")
    Set<Book> getGoldenBooksWithLessThanCopies(EditionType editionType, int copies);

    @Query("SELECT b FROM Book b WHERE b.price < :lowerThanPrice OR b.price > :higherThanPrice")
    Set<Book> getBooksByPriceRange(double lowerThanPrice, double higherThanPrice);

    @Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) != :year")
    Set<Book> getNotReleasedBooksInYear(int year);

    Set<Book> getBooksByReleaseDateBefore(LocalDate releaseDate);

    Set<Book> getBooksByTitleContaining(String title);
}
