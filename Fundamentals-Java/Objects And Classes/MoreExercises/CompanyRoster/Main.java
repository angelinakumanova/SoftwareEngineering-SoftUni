package ObjectsAndClasses.MoreExercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String employeeInfo = scanner.nextLine();
            String[] infoParts = employeeInfo.split(" ");
            Department department = new Department(infoParts[3], Double.parseDouble(infoParts[1]));
            if (departmentExists(departments, infoParts[3])) {
                double salaryDepartment = 0;
                for (Department dp : departments) {
                    if (infoParts[3].equals(dp.getNameOfDepartment())) {
                        salaryDepartment += dp.getSalaryOfDepartment() + Double.parseDouble(infoParts[1]);
                        dp.setSalaryOfDepartment(salaryDepartment);
                    }
                }


            } else {
                departments.add(department);
            }

            Employee employee = new Employee(infoParts[0],
                    Double.parseDouble(infoParts[1]),
                    infoParts[2],
                    department);
            if (infoParts.length >= 5) {
                if (infoParts.length == 5) {
                    if (infoParts[4].contains("@")) {
                        employee.setEmail(infoParts[4]);
                    } else {
                        employee.setAge(infoParts[4]);
                    }
                } else {
                    employee.setEmail(infoParts[4]);
                    employee.setAge(infoParts[5]);
                }
            }
            employees.add(employee);
        }

        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary).reversed());
        Collections.sort(departments, Comparator.comparingDouble(Department::getSalaryOfDepartment).reversed());
        System.out.printf("Highest Average Salary: %s%n", departments.get(0).getNameOfDepartment());
        for (Employee employee : employees) {
            if (employee.getDepartment().getNameOfDepartment().equals(departments.get(0).getNameOfDepartment())) {
                System.out.printf("%s %.2f %s %s%n",
                        employee.getName(),
                        employee.getSalary(),
                        employee.getEmail(),
                        employee.getAge());
            }

        }


    }


    public static boolean departmentExists (List<Department> departments, String department) {
        for (Department department1 : departments) {
            if (department.equals(department1.getNameOfDepartment())) {
                return true;
            }
        }
        return false;
    }
}
