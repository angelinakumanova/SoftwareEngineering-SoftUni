package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
