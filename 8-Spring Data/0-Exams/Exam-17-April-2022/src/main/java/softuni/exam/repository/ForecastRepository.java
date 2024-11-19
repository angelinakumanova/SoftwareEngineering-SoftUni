package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.enums.Weekday;

import java.util.Optional;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findByCityIdAndDayOfWeek(Long cityId, Weekday weekday);
}
