package bg.softuni.usersystem.data.repositories;

import bg.softuni.usersystem.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
