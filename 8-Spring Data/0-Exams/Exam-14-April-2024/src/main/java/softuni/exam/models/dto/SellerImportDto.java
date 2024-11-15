package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class SellerImportDto {
    @NotNull @Length(min = 2, max = 30)
    private String firstName;
    @NotNull @Length(min = 2, max = 30)
    private String lastName;
    @NotNull @Length(min = 3, max = 6)
    private String personalNumber;

    public SellerImportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }
}
