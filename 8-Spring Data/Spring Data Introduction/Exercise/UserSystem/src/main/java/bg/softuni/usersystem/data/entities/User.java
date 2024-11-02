package bg.softuni.usersystem.data.entities;

import bg.softuni.usersystem.data.entities.annotations.Password;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 4, max = 30)
    private String username;

    @NotNull
    @Size(min = 6, max = 50)
    @Password(containsLowerCase = true, containsUpperCase = true, containsDigit = true, containsSpecialSymbol = true)
    private String password;

    @NotNull
    @Email(regexp = "^[a-zA-Z0-9]+([._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(-?[a-zA-Z0-9]+)*(\\\\.[a-zA-Z0-9]+(-?[a-zA-Z0-9]+)*)+$",
            message = "Invalid email format")
    private String email;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;

    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
