package Lab.vehicle_hierarchy.table_per_class;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Plane extends Vehicle {
    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
