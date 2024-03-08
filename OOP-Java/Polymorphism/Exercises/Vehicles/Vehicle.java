package Polymorphism.Exercises.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double travelledDistance;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.travelledDistance = 0.0;
    }
    public void drive(Double kilometres) {
        DecimalFormat df = new DecimalFormat("0.##");

        double neededFuel = this.fuelConsumption * kilometres;

        if (this.fuelQuantity >= neededFuel) {
            System.out.printf("%s travelled %s km%n",
                    this.getClass().getSimpleName(),
                    df.format(kilometres));

            this.fuelQuantity -= neededFuel;
            this.setTravelledDistance(this.getTravelledDistance() + kilometres);
        } else {
            System.out.printf("%s needs refueling%n",
                    this.getClass().getSimpleName());
        }
    }
    public void refuel(Double liters) {

        if (this instanceof Truck) {
            liters -= (liters * 0.05);
        }

        this.fuelQuantity = this.fuelQuantity + liters;
    }

    public Double getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
