package Lab.vehicle_hierarchy.joined;

import jakarta.persistence.*;

import java.math.BigDecimal;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private String model;

    private BigDecimal price;

    @Column(name = "fuel_type")
    private String fuelType;

    protected Vehicle2() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = this.type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @PrePersist
    protected void onPersist() {
        this.type = getClass().getSimpleName();
    }
}
