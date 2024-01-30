package DefiningClasses.Exercises.CarSalesman;

public class Engine {
    //An Engine has a model, power, displacement, and efficiency
    private String model;
    private String power;
    private int displacement;
    private String efficiency;

    public Engine(String model, String power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power) {
        this(model, power, -1, "n/a");
    }

    public Engine(String model, String power, int displacement) {
        this(model, power, displacement, "n/a");
    }
    public Engine(String model, String power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%n",
                this.model,
                this.power,
                this.displacement == -1 ? "n/a" : this.displacement,
                efficiency);
    }
}
