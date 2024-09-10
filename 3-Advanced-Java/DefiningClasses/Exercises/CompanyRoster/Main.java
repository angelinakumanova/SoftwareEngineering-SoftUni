package DefiningClasses.Exercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            departments.putIfAbsent(department, new Department(department));

            if (tokens.length == 5) {
                if (tokens[4].matches("\\d+")) {
                    departments.get(department)
                            .addEmployee(new Employee(name, salary, position, department, Integer.parseInt(tokens[4])));
                } else {
                    departments.get(department)
                            .addEmployee(new Employee(name, salary, position, department, tokens[4]));
                }
            } else if (tokens.length == 6) {
                departments.get(department)
                        .addEmployee(new Employee(name, salary, position, department, tokens[4], Integer.parseInt(tokens[5])));
            } else {
                departments.get(department)
                        .addEmployee(new Employee(name, salary, position, department));
            }
        }

        String highestAvgSalaryDepartment = "";
        double highestAvgSalary = 0.0;

        for (Department department : departments.values()) {
            double avgSalary = department.calculateAverageSalary();
            if (avgSalary > highestAvgSalary) {
                highestAvgSalary = avgSalary;
                highestAvgSalaryDepartment = department.getName();
            }
        }
        
        System.out.println("Highest Average Salary: " + highestAvgSalaryDepartment);
        for (Department department : departments.values()) {
            if (department.getName().equals(highestAvgSalaryDepartment)) {
                for (Employee employee : department.sortEmployees()) {
                    System.out.println(employee);
                }
            }
        }

    }
}
