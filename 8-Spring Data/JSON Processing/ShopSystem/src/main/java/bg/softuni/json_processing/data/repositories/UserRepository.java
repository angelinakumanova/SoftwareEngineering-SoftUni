package bg.softuni.json_processing.data.repositories;

import bg.softuni.json_processing.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u " +
            "JOIN u.products p " +
            "WHERE p.buyer IS NOT NULL " +
            "ORDER BY u.lastName ASC, u.firstName ASC")
    List<User> getUsersWithSoldProducts();
}
