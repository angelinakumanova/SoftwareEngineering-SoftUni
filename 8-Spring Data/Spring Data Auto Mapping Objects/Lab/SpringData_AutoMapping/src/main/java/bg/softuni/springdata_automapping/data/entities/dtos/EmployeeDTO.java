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
}
