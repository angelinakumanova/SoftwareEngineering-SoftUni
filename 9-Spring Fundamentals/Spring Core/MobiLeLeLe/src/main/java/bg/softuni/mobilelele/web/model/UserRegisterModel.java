package bg.softuni.mobilelele.web.model;

import bg.softuni.mobilelele.data.entities.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterModel {

    @NotEmpty @Size(min = 3, max = 20)
    private String firstName;

    @NotEmpty @Size(min = 3, max = 20)
    private String lastName;

    @NotEmpty @Size(min = 3, max = 20)
    private String username;

    @NotEmpty @Size(min = 6, max = 20)
    private String password;


    public UserRegisterModel() {}

    public @NotEmpty @Size(min = 3, max = 20) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty @Size(min = 3, max = 20) String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty @Size(min = 3, max = 20) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty @Size(min = 3, max = 20) String lastName) {
        this.lastName = lastName;
    }

    public @NotEmpty @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty @Size(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @NotEmpty @Size(min = 6, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty @Size(min = 6, max = 20) String password) {
        this.password = password;
    }
}
