package Lab.vehicle_hierarchy.joined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//@Entity
public class Plane2 extends Vehicle2 {
    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
