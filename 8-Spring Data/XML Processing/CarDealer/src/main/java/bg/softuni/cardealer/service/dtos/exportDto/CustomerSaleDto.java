package bg.softuni.cardealer.service.dtos.exportDto;

import java.math.BigDecimal;

public class CustomerSaleDto {
    private String fullName;
    private Integer boughtCars;
    private BigDecimal spentMoney;

    public CustomerSaleDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
