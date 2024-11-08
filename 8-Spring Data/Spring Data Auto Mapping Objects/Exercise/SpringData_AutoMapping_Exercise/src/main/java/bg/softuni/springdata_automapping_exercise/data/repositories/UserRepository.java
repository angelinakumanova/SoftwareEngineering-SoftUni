package bg.softuni.springdata_automapping_exercise.data.repositories;


import bg.softuni.springdata_automapping_exercise.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
