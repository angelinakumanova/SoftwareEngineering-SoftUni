package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.delicacies.interfaces;

public class Stolen extends BaseDelicacy{
    private static final double INITIAL_PORTION = 250;
    public Stolen(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
