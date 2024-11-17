package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
