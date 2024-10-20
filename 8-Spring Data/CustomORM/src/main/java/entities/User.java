package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {
    @Id
    @Column(name ="id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "registration")
    private LocalDate registration;

    @Column(name = "password")
    private String password;

    public User() {}

    public User(String username, int age, LocalDate registration) {
        this.username = username;
        this.age = age;
        this.registration = registration;
    }

    public User(String username, int age, LocalDate registration, String password) {
        this.username = username;
        this.age = age;
        this.registration = registration;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", registration=" + registration +
                '}';
    }
}
