package Lab.vehicle_hierarchy.single_table;

import jakarta.persistence.Entity;

//@Entity
public class Car3 extends Vehicle3 {
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
