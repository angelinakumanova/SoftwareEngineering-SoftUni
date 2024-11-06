package bg.softuni.springdata_automapping.service;


import bg.softuni.springdata_automapping.data.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployeesBornBefore(int yearBornBefore);
}
