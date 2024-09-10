package Polymorphism.Exercises.VehiclesExtension;

public interface Vehicle {
    void drive(Double kilometres);
    void refuel(Double liters);
    default void setEmpty(boolean isEmpty) {

    }
}
