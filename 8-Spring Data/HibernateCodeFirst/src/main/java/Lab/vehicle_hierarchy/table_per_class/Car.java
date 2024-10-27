package Lab.vehicle_hierarchy.table_per_class;

import Lab.relations.PlateNumber;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private int seats;

    @OneToOne
    private PlateNumber plateNumber;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
