package bg.softuni.cardealer.service.dtos.exportDto.totalSales;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.math.BigDecimal;

public class CustomerSaleDto {
    @JacksonXmlProperty(localName = "full-name", isAttribute = true)
    private String fullName;
    @JacksonXmlProperty(localName = "bought-cars", isAttribute = true)
    private Integer boughtCars;
    @JacksonXmlProperty(localName = "spent-money", isAttribute = true)
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
