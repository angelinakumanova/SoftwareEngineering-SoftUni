package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.enums.StarType;

import java.util.List;
import java.util.Optional;

public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findByName(String name);

    List<Star> findByObserversIsNullAndStarTypeOrderByLightYears(StarType starType);
}
