package Exams.Exam_18April22.BusinessLogic.zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    //WaterArea

    private static final double INITIAL_KILOGRAMS = 2.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + 7.50);
    }
}
