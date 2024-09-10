package Exams.Exam_9April22.HighQualityStructure.fairyShop.models;

public class Sleepy extends BaseHelper {
    private static final int INITIAL_ENERGY = 50;
    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        super.setEnergy(super.getEnergy() - 5);
        super.work();
    }
}
