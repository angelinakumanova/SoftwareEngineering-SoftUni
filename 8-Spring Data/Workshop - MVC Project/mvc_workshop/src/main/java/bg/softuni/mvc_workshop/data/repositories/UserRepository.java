package bg.softuni.mvc_workshop.data.repositories;

import bg.softuni.mvc_workshop.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
