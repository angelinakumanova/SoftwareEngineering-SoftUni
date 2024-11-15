package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Volcanologist;

public interface VolcanologistRepository extends JpaRepository<Volcanologist, Long> {


}
