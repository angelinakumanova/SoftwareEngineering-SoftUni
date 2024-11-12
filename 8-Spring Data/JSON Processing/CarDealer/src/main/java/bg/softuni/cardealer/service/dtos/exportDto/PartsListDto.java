package bg.softuni.cardealer.service.dtos.exportDto;

import java.math.BigDecimal;

public class PartsListDto {
    private String name;
    private BigDecimal price;

    public PartsListDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
