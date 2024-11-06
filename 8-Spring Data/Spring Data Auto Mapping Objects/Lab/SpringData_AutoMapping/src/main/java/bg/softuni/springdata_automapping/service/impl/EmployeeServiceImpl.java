package bg.softuni.springdata_automapping.service.impl;

import bg.softuni.springdata_automapping.data.entities.Employee;
import bg.softuni.springdata_automapping.data.entities.dtos.EmployeeDTO;
import bg.softuni.springdata_automapping.data.repositories.EmployeeRepository;
import bg.softuni.springdata_automapping.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<EmployeeDTO> getEmployeesBornBefore(int yearBornBefore) {
        List<Employee> employees = employeeRepository.getEmployeesByBirthDateBeforeOrderBySalaryDesc(LocalDate.of(yearBornBefore, 1, 1));

        return employees.stream().map(employee -> this.modelMapper.map(employee, EmployeeDTO.class)).toList();

    }

    @Override
    public List<EmployeeDTO> getEmployeesWithoutManager() {
        Set<Employee> employees = employeeRepository.getEmployeesByManagerIdIsNull();

        return employees.stream().map(employee -> this.modelMapper.map(employee, EmployeeDTO.class)).toList();
    }
}
