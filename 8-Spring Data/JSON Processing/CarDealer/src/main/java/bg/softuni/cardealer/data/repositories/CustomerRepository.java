package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
