package bg.softuni.spring_data.repositories;

import bg.softuni.spring_data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
}
