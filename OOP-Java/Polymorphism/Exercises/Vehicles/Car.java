package Polymorphism.Exercises.Vehicles;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }
}
