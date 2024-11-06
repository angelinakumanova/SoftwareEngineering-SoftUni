package bg.softuni.springdata_automapping.service;


import bg.softuni.springdata_automapping.data.entities.dtos.EmployeeDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployeesBornBefore(int yearBornBefore);

    List<EmployeeDTO> getEmployeesWithoutManager();
}
