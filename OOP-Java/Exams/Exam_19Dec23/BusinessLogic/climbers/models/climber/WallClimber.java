package Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber;

public class WallClimber extends BaseClimber {
    private static final double INITIAL_STRENGTH = 90;
    private static final int DECREASE_STRENGTH = 30;
    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        double strength = super.getStrength() - DECREASE_STRENGTH;
        if (strength < 0) {
            strength = 0;
        }

        super.setStrength(strength);
    }
}
