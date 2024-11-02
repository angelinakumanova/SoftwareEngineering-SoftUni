package bg.softuni.bookshop.data.repositories;


import bg.softuni.bookshop.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
