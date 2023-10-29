package ObjectsAndClasses.MoreExercises.CompanyRoster;

import java.util.List;

public class Department {

    private String nameOfDepartment;
    private double salaryOfDepartment;


    public Department(String nameOfDepartment, double salaryOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
        this.salaryOfDepartment = salaryOfDepartment;
    }


    public String getNameOfDepartment() {
        return this.nameOfDepartment;
    }

    public double getSalaryOfDepartment() {
        return this.salaryOfDepartment;
    }

    public void setSalaryOfDepartment(double salaryOfDepartment) {
        this.salaryOfDepartment = salaryOfDepartment;
    }
}
