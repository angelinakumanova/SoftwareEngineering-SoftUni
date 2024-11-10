package bg.softuni.json_processing.data.repositories;

import bg.softuni.json_processing.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
