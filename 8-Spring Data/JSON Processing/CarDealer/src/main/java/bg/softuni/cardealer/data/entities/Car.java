package bg.softuni.cardealer.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String make;
    private String model;
    @Column(name = "travelled_distance")
    private Long travelledDistance;
    @ManyToMany
    @JoinTable(name = "cars_parts",
                joinColumns = @JoinColumn(name = "car_id"),
                inverseJoinColumns = @JoinColumn(name = "part_id"))
    private Set<Part> parts;
//    @OneToMany(mappedBy = "customer")
//    private Set<Sale> sales;

    public Car() {
        this.parts = new HashSet<>();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
