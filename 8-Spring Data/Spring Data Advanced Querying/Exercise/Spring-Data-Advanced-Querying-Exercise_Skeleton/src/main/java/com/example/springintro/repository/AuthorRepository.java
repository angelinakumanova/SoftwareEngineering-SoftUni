package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY SIZE(a.books) DESC")
    List<Author> findAllByBooksSizeDESC();

    Set<Author> getAuthorsByFirstNameEndingWith(String prefix);

    @Query("SELECT SUM(b.copies) FROM Author a" +
            " JOIN a.books b" +
            " WHERE CONCAT_WS(' ', a.firstName, a.lastName) = :authorName")
    int getTotalCopiesByAuthorName(String authorName);

    @Procedure(procedureName = "get_total_books_by_author")
    int getBooksCount(@Param("author_name") String authorName);
}
