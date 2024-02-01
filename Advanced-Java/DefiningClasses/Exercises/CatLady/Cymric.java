package DefiningClasses.Exercises.CatLady;

public class Cymric extends Cat{
    private double lengthOfFur;

    public Cymric(String name, String type, double lengthOfFur) {
        super(name, type);
        this.lengthOfFur = lengthOfFur;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", super.getType(), super.getName(), this.lengthOfFur);
    }
}
