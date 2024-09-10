package DefiningClasses.Exercises.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Department {

    private String name;
    private List<Employee> employeesList;

    public Department(String name) {
        this.name = name;
        this.employeesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }


    public List<Employee> sortEmployees() {
        return this.employeesList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    public double calculateAverageSalary() {
        if (employeesList.isEmpty()) {
            return 0.0;
        }

        double totalSalary = employeesList.stream().mapToDouble(Employee::getSalary).sum();
        return totalSalary / employeesList.size();
    }




}
