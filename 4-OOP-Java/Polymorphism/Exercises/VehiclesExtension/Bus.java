package Polymorphism.Exercises.VehiclesExtension;

public class Bus extends VehicleImpl{
    private static final boolean IS_EMPTY = true;
    private boolean isEmpty = IS_EMPTY;
    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public void drive(Double kilometres) {
        if (!isEmpty) {
            super.setFuelConsumption(super.getFuelConsumption() + 1.4);
        } else {
            super.setFuelConsumption(super.getFuelConsumption() - 1.4);
        }
        super.drive(kilometres);
    }
}
