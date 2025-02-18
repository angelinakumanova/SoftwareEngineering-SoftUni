package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "astronomers")
public class Astronomer extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Double salary;
    @Column(name = "average_observation_hours", nullable = false)
    private Double averageObservationHours;
    private LocalDate birthday;
    @ManyToOne
    @JoinColumn(name = "observing_star_id")
    private Star star;

    public Astronomer() {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }
}
