package bg.softuni.json_processing.data.repositories;

import bg.softuni.json_processing.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> getProductsByPriceBetweenOrderByPriceAsc(BigDecimal lower, BigDecimal upper);
}
