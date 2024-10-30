package university.system.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "students")
public class Student extends Person {

    @Column (name = "avg_grade")
    private double avgGrade;

    private int attendance;

    @ManyToMany(mappedBy = "students", targetEntity = Course.class)
    private Set<Course> courses;

    public Student() {
        this.courses = new HashSet<>();
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }
}
