package Exams.Exam_18April23.HighQualityStructure.vehicleShop.models.worker;

public class SecondShift extends BaseWorker {

    private static final int INITIAL_STRENGTH = 70;
    public SecondShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void working() {
        super.working();
        int currentStrength = super.getStrength() - 5;

        if (currentStrength < 0) {
            currentStrength = 0;
        }

        super.setStrength(currentStrength);
    }
}
