package bg.softuni.json_processing.service.dtos;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ProductSeedJsonDto {
    @Length(min = 3)
    private String name;
    private BigDecimal price;

    public ProductSeedJsonDto() {
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
