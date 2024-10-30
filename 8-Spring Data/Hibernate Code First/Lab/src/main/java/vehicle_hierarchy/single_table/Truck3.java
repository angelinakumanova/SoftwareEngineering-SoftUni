package vehicle_hierarchy.single_table;


import jakarta.persistence.Column;

//@Entity
public class Truck3 extends Vehicle3 {
    @Column(name = "load_capacity")
    private Double loadCapacity;

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
