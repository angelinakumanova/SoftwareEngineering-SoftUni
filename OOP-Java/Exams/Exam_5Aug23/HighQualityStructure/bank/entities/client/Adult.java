package Exams.Exam_5Aug23.HighQualityStructure.bank.entities.client;

public class Adult extends BaseClient {

    //CentralBank
    private static final int INITIAL_INTEREST = 4;

    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + 2);
    }
}
