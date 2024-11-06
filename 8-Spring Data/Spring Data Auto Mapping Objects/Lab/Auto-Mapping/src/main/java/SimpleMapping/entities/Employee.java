package SimpleMapping.entities;

import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private LocalDate birthDate;
    private String address;

    public Employee(String firstName, String lastName, double salary, LocalDate birthDate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        this.address = address;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
