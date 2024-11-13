package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findSaleByCarId(Long id);

    Set<Sale> getAllBy();
}
