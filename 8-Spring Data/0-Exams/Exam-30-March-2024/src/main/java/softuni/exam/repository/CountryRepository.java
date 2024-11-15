package softuni.exam.repository;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Country;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {


    Optional<Country> findByName(String name);
}
