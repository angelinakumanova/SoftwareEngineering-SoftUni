package bg.softuni.cardealer.service.dtos.importDto;

import java.math.BigDecimal;

public class CreatePartJsonDto {
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public CreatePartJsonDto() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
