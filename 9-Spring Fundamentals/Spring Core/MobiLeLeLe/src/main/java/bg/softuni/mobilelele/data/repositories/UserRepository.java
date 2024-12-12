package bg.softuni.mobilelele.data.repositories;

import bg.softuni.mobilelele.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
