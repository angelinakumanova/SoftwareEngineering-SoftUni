package Lab.vehicle_hierarchy.table_per_class;


import Lab.relations.Driver;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    @Column(name = "load_capacity")
    private Double loadCapacity;

    @ManyToMany(mappedBy = "trucks", targetEntity = Driver.class)
    private Set<Driver> drivers;

    public Truck() {
        this.drivers = new HashSet<>();
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
