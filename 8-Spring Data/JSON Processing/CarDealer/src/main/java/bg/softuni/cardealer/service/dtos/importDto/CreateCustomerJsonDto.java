package bg.softuni.cardealer.service.dtos.importDto;

import java.time.LocalDate;

public class CreateCustomerJsonDto {
    private String name;
    private LocalDate birthDate;
    private boolean isYoungDriver;

    public CreateCustomerJsonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
