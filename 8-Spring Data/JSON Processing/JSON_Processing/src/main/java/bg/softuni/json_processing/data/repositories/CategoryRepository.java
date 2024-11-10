package bg.softuni.json_processing.data.repositories;

import bg.softuni.json_processing.data.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
