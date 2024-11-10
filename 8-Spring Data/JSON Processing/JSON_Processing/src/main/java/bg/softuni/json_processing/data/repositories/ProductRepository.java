package bg.softuni.json_processing.data.repositories;

import bg.softuni.json_processing.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
