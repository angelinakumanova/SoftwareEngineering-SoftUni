package bg.softuni.springdata_automapping.data.repositories;

import bg.softuni.springdata_automapping.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByBirthDateBeforeOrderBySalaryDesc(LocalDate birthdate);
    Set<Employee> getEmployeesByManagerIdIsNull();
}
