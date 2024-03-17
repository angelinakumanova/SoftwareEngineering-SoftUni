package Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climber;

public class RockClimber extends BaseClimber {
    private static double initialStrength = 120;
    private static final int DECREASE_STRENGTH = 60;

    public RockClimber(String name) {
        super(name, initialStrength);
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
