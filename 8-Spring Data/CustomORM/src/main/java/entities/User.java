package entities;

import java.time.LocalDate;

public class User {
    private int id;
    private String username;
    private int age;
    private LocalDate registration;

    public User(int id, String username, int age, LocalDate registration) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.registration = registration;
    }

}
