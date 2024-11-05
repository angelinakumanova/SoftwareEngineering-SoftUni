package SimpleMapping;

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
}
