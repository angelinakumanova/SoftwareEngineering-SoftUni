package bg.softuni.usersystem.data.repositories;

import bg.softuni.usersystem.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> findByEmailContaining(String emailProvider);
}
