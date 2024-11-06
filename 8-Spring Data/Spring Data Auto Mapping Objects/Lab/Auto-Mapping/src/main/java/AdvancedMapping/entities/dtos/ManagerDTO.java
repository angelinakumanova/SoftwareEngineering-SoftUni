package AdvancedMapping.entities.dtos;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private double salary;
    private List<EmployeeDTO> staff;

    public ManagerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<EmployeeDTO> getStaff() {
        return staff;
    }

    public void setStaff(List<EmployeeDTO> employees) {
        this.staff = employees;
    }

    @Override
    public String toString() {
        String formattedStaff = staff.stream().map(e -> "- " + e.toString()).collect(Collectors.joining("\n"));
        return String.format("%s %s | Employees: %d%n%s", firstName, lastName, staff.size(), formattedStaff);
    }
}
