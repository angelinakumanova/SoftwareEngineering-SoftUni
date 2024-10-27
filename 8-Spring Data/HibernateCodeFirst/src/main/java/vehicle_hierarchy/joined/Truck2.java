package vehicle_hierarchy.joined;


import jakarta.persistence.Column;

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
