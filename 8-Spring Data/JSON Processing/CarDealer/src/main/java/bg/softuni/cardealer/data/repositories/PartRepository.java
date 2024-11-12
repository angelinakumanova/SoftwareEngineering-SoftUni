package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
