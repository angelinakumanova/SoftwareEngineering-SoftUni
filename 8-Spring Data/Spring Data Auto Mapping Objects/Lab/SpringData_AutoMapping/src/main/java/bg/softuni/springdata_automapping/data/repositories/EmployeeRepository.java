package bg.softuni.springdata_automapping.data.repositories;

import bg.softuni.springdata_automapping.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByBirthDateBefore(LocalDate birthdate);
}
