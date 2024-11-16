package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LibraryMemberImportDto {
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;
    @Length(min = 2, max = 40)
    private String address;
    @NotNull
    @Length(min = 2, max = 20)
    private String phoneNumber;

    public LibraryMemberImportDto() {}

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

    public @Length(min = 2, max = 40) String getAddress() {
        return address;
    }

    public void setAddress(@Length(min = 2, max = 40) String address) {
        this.address = address;
    }

    public @NotNull @Length(min = 2, max = 20) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull @Length(min = 2, max = 20) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
