package Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.cars;

import static Exams.Exam_20Dec21.BusinessLogic.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    private static final double DEFAULT_CUBIC_CENTIMETERS = 3000;
    private static final int MINIMUM_HORSEPOWER = 250;
    private static final int MAXIMUM_HORSEPOWER = 450;
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER || horsePower > MAXIMUM_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
