package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
