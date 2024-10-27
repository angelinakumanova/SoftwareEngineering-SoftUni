package Lab.vehicle_hierarchy.joined;

import jakarta.persistence.Entity;

//@Entity
public class Car2 extends Vehicle2 {
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

}
