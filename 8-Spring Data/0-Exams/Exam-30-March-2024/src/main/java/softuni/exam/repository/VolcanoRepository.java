package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Volcano;

public interface VolcanoRepository extends JpaRepository<Volcano, Long> {

}
