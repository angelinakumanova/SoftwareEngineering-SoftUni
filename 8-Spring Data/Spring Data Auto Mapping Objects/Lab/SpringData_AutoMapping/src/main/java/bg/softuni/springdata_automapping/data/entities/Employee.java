package bg.softuni.springdata_automapping.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "employees")
@Getter@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    private Employee manager;

    public Employee() {
    }
}
