package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces;

public class Gingerbread extends BaseDelicacy {
    private static final double INITIAL_PORTION = 200;
    public Gingerbread(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
