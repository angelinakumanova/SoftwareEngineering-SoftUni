package ObjectsAndClasses.MoreExercises.CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model) {
        this.model = model;
        this.engine = null;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return this.model + ":" + "\n"
                + "  " + engine.toString()
                + "  Weight: " + this.weight + "\n"
                + "  Color: " + this.color + "\n";

    }
}
