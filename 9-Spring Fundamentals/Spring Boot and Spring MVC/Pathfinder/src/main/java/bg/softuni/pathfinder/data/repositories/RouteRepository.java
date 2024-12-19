package bg.softuni.pathfinder.data.repositories;

import bg.softuni.pathfinder.data.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> getRoutesBy();
}
