package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {
    @Id
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "registration")
    private LocalDate registration;

    public User(String username, int age, LocalDate registration) {
        this.username = username;
        this.age = age;
        this.registration = registration;
    }

    public void setId(int id) {
        this.id = id;
    }
}
