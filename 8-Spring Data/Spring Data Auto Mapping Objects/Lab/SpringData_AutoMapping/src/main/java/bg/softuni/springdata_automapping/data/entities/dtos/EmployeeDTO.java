package bg.softuni.springdata_automapping.data.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private double salary;
    private String managerLastName;

    public EmployeeDTO() {
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f - Manager: %s",
                this.firstName, this.lastName, this.salary,
                this.managerLastName == null ? "[no manager]" : this.managerLastName);
    }
}
