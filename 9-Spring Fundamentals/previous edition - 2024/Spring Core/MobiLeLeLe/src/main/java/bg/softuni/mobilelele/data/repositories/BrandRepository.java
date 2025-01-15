package bg.softuni.mobilelele.data.repositories;

import bg.softuni.mobilelele.data.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
