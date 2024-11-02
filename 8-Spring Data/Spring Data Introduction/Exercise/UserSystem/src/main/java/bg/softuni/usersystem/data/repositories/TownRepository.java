package bg.softuni.usersystem.data.repositories;

import bg.softuni.usersystem.data.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Long> {
    Town findByName(String name);
}
