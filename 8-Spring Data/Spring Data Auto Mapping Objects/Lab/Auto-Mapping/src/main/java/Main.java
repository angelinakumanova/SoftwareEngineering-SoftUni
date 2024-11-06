import SimpleMapping.Employee;
import SimpleMapping.EmployeeDTO;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Jack", "Smith", 5000.0, LocalDate.of(1990, 2, 5), "Street 123");
        ModelMapper modelMapper = new ModelMapper();

        EmployeeDTO newEmployee = modelMapper.map(employee, EmployeeDTO.class);
        System.out.println(newEmployee);
    }
}
