package softuni.exam.models.dto;

import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.enums.StatusType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class PersonImportDto {
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;
    @NotNull
    @Email(regexp = "^[a-zA-Z0-9_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
    private String email;
    @Length(min = 2, max = 13)
    private String phone;
    @NotNull
    private StatusType statusType;
    private Long country;

    public PersonImportDto() {
    }

    public @NotNull @Length(min = 2, max = 30) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Length(min = 2, max = 30) String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @Length(min = 2, max = 30) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Length(min = 2, max = 30) String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @Email(regexp = "^[a-zA-Z0-9_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email(regexp = "^[a-zA-Z0-9_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$") String email) {
        this.email = email;
    }

    public @Length(min = 2, max = 13) String getPhone() {
        return phone;
    }

    public void setPhone(@Length(min = 2, max = 13) String phone) {
        this.phone = phone;
    }

    public @NotNull StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(@NotNull StatusType statusType) {
        this.statusType = statusType;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
