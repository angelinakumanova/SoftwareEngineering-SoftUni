package Polymorphism.Exercises.VehiclesExtension;

public class Truck extends VehicleImpl {
    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }


}
