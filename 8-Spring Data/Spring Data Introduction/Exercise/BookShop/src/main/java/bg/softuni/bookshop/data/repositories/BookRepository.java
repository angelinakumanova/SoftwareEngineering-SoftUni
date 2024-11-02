package bg.softuni.bookshop.data.repositories;


import bg.softuni.bookshop.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findAllByReleaseDateAfter(LocalDate date);
}
