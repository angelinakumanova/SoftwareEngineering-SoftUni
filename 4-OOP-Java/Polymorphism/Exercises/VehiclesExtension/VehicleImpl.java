package Polymorphism.Exercises.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double travelledDistance;
    private Double tankCapacity;

    public VehicleImpl(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.travelledDistance = 0.0;
        this.tankCapacity = tankCapacity;
    }

    @Override
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

    @Override
    public void refuel(Double liters) {

        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this instanceof Truck) {
            liters -= (liters * 0.05);
        }

        double newFuelQuantity = this.fuelQuantity + liters;

        if (newFuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity = newFuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
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
