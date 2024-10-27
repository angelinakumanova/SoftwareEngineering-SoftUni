package Lab.vehicle_hierarchy;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle {
    @Column(name = "load_capacity")
    private Double loadCapacity;

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
