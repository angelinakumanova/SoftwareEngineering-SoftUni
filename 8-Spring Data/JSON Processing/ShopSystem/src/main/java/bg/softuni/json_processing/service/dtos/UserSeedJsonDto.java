package bg.softuni.json_processing.service.dtos;

import org.hibernate.validator.constraints.Length;

public class UserSeedJsonDto {
    private String firstName;
    @Length(min = 3, message = "Last name should be at least 3 characters long")
    private String lastName;
    private int age;

    public UserSeedJsonDto() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
