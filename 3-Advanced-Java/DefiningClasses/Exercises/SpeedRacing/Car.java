package DefiningClasses.Exercises.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTravelled = 0;


    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
    }
    public void drive(int distanceToTravel) {
        double requiredFuel = distanceToTravel * this.fuelCostFor1km;
        if (requiredFuel <= fuelAmount) {
            fuelAmount -= requiredFuel;
            distanceTravelled += distanceToTravel;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }
}
