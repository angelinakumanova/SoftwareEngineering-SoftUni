package Lab.vehicle_hierarchy.joined;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//@Entity
public class Truck2 extends Vehicle2 {
    @Column(name = "load_capacity")
    private Double loadCapacity;

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
