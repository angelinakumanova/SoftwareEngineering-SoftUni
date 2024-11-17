package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
