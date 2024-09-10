package Exams.Exam_8April23.BusinessLogic.robotService.entities.robot;

public class MaleRobot extends BaseRobot{
    private static final int INITIAL_KILOGRAMS = 9;

    //Can only live in MainService
    public MaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 3);
    }
}
