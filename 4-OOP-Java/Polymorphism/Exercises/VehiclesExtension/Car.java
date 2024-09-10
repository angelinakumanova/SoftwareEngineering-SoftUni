package Polymorphism.Exercises.VehiclesExtension;

public class Car extends VehicleImpl {

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }
}
