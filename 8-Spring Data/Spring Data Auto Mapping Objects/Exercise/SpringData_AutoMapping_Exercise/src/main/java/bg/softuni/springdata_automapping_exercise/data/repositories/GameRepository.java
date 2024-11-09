package bg.softuni.springdata_automapping_exercise.data.repositories;

import bg.softuni.springdata_automapping_exercise.data.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAll();

    Optional<Game> findGameByTitle(String title);
}
