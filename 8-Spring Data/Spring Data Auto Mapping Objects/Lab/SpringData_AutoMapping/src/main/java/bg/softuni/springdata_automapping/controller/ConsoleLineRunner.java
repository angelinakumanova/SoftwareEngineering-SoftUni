package bg.softuni.springdata_automapping.controller;

import bg.softuni.springdata_automapping.data.entities.dtos.EmployeeDTO;
import bg.softuni.springdata_automapping.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final BufferedReader reader;
    private final EmployeeService employeeService;

    public ConsoleLineRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        int yearBornBefore = Integer.parseInt(reader.readLine());

        List<EmployeeDTO> employees = employeeService.getEmployeesBornBefore(yearBornBefore);

        employees.forEach(System.out::println);
    }
}
