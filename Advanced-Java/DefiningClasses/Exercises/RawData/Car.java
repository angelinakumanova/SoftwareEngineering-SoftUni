package DefiningClasses.Exercises.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new ArrayList<>();
    }

    public void addTires(Tire tire) {
        tires.add(tire);
    }

    public boolean isFragileCar(Car car) {
        if (car.cargo.getCargoType().equals("fragile")) {
            boolean isLessThanOne = false;
            for (Tire tire : car.tires) {
                if (tire.getTirePressure() < 1) {
                    isLessThanOne = true;
                    break;
                }
            }
            if (isLessThanOne) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlammableCar(Car car) {
        if (car.cargo.getCargoType().equals("flamable")) {
            if (car.engine.getEnginePower() > 250) {
                return true;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
