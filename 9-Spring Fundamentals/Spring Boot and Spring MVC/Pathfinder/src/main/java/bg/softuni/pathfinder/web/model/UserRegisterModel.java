package bg.softuni.pathfinder.web.model;

import bg.softuni.pathfinder.util.validation.EqualPasswords;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@EqualPasswords
public class UserRegisterModel {
    @NotEmpty
    private String username;

    @NotEmpty
    @Length(min = 5)
    private String fullName;

    @NotEmpty
    @Email
    private String email;

    @Min(0)
    @Max(90)
    private Integer age;

    @NotEmpty
    @Size(min = 5)
    private String password;

    @NotEmpty
    private String confirmPassword;

    public UserRegisterModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
