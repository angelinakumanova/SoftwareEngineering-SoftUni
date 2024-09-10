package Encapsulation.Lab.FirstAndReserveTeam;

import java.text.DecimalFormat;

public class Person {
    private static final String STRING_TEMPLATE = "%s %s gets %s leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0##");
        return String.format(STRING_TEMPLATE, this.getFirstName(), this.getLastName(), df.format(this.getSalary()));
    }

    public void increaseSalary(double bonus) {
        bonus = getAge() < 30 ? bonus / 2 : bonus;
        this.setSalary(((getSalary() * bonus) / 100) + getSalary());
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private double getSalary() {
        return this.salary;
    }
}
