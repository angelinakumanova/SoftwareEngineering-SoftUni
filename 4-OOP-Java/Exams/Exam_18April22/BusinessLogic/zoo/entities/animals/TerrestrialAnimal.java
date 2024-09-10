package Exams.Exam_18April22.BusinessLogic.zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    // LandArea

    private static final double INITIAL_KILOGRAMS = 5.50;
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + 5.70);
    }
}
