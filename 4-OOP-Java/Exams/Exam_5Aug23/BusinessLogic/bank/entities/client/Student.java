package Exams.Exam_5Aug23.BusinessLogic.bank.entities.client;

public class Student extends BaseClient {
    // can only live in BranchBank

    private static final int INITIAL_INTEREST = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + 1);
    }

}
