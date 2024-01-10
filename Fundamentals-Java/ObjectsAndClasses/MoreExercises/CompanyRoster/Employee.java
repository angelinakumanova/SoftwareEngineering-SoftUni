package ObjectsAndClasses.MoreExercises.CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private Department department;
    private String email;
    private String age;


    public Employee(String name, double salary, String position, Department department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = "-1";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Department getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAge() {
        return this.age;
    }
}
