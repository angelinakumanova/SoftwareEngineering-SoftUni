package bg.softuni.mvc_workshop.data.repositories;

import bg.softuni.mvc_workshop.data.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
