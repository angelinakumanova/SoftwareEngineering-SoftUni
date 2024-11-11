package bg.softuni.json_processing.service.dtos;

import java.math.BigDecimal;

public class ProductPriceRangeDto {
    private String name;
    private BigDecimal price;
    private String seller;

    public ProductPriceRangeDto() {
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
