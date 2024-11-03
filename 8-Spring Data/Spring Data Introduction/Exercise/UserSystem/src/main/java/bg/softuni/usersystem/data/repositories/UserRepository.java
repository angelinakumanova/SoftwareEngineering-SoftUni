package bg.softuni.usersystem.data.repositories;

import bg.softuni.usersystem.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> findByEmailContaining(String emailProvider);

    @Modifying
    @Query("UPDATE User SET isDeleted = true WHERE lastTimeLoggedIn < :dateTime AND isDeleted = false")
    int markUsersAsDeletedBefore(@Param("dateTime") LocalDateTime localDateTime);

    @Modifying
    @Query("DELETE FROM User WHERE isDeleted = true")
    int deleteAllByIsDeletedTrue();
}
