package bg.softuni.springdata_automapping_exercise.data.repositories;

import bg.softuni.springdata_automapping_exercise.data.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    void updateGame(Game game);
}
