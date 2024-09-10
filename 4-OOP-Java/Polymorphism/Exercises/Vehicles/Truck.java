package Polymorphism.Exercises.Vehicles;

public class Truck extends Vehicle{
    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }


}
