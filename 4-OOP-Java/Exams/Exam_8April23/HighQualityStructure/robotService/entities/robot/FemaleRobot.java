package Exams.Exam_8April23.HighQualityStructure.robotService.entities.robot;

public class FemaleRobot extends BaseRobot {
    private static final int INITIAL_KILOGRAMS = 7;
    //can ony live in SecondaryService
    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);
    }
}
