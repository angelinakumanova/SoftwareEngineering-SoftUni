package bg.softuni.springdata_automapping_exercise.service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UserCreateDto {
    @Email(regexp = "^[A-Za-z0-9\\.]+@[A-Za-z]+\\.[A-Za-z\\.]+$", message = "Invalid email format")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z!@\\d]{6,}$", message = "Invalid password")
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserCreateDto() {
    }

    public UserCreateDto(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
