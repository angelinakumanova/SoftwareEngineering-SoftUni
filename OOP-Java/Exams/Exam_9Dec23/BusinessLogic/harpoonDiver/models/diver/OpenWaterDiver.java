package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver {
    private static final double INITIAL_OXYGEN = 30;
    public OpenWaterDiver(String name) {
        super(name, INITIAL_OXYGEN);
    }
}
