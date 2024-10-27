package vehicle_hierarchy.single_table;

import jakarta.persistence.Column;

//@Entity
public class Plane3 extends Vehicle3 {
    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
