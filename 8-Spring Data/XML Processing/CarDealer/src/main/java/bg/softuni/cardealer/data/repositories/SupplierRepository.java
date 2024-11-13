package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Set<Supplier> findAllByIsImporterIsFalse();
}
