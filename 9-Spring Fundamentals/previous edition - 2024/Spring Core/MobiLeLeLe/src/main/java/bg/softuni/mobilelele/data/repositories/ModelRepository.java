package bg.softuni.mobilelele.data.repositories;

import bg.softuni.mobilelele.data.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
