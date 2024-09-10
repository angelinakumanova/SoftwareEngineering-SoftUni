package ObjectsAndClasses.MoreExercises.CarSalesman;

public class Engine {

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return this.model + ":" + "\n"
                + "    Power: " + this.power + "\n"
                + "    Displacement: " + this.displacement + "\n"
                + "    Efficiency: " + this.efficiency + "\n";
    }
}
