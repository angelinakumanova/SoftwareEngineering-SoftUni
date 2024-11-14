package bg.softuni.cardealer.service.dtos.exportDto.salesDiscount;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.math.BigDecimal;

public class SaleDiscountDto {
    private CarDiscountDto car;
    @JacksonXmlProperty(localName = "customer-name")
    private String customerName;
    private Double discount;
    private BigDecimal price;
    @JacksonXmlProperty(localName = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleDiscountDto() {
    }

    public CarDiscountDto getCar() {
        return car;
    }

    public void setCar(CarDiscountDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
