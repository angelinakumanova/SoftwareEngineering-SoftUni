package Lab.vehicle_hierarchy;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
