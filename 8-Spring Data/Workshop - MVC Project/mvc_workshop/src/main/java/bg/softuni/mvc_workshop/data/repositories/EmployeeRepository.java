package bg.softuni.mvc_workshop.data.repositories;

import bg.softuni.mvc_workshop.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByAgeGreaterThan(Integer age);
}
