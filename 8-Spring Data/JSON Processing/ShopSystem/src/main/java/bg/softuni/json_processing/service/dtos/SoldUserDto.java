package bg.softuni.json_processing.service.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SoldUserDto {
    private String firstName;
    private String lastName;
    private List<SoldProductDto> soldProducts;

    public SoldUserDto() {
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

    public List<SoldProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
