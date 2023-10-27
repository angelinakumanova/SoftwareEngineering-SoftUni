package ObjectsAndClasses.Exercises.VehicleCatalogue;

public class Truck {

    private String model;
    private String color;
    private int horsepower;


    public Truck(String model, String color, int horsepower) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }
}
