package bg.softuni.cardealer.data.repositories;

import bg.softuni.cardealer.data.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarRepository extends JpaRepository<Car, Long> {

    Set<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);

    Set<Car> getAllBy();
}
