package Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan;

public class MortgageLoan extends BaseLoan {
    private static final int DEFAULT_INTEREST_RATE = 3;
    private static final double DEFAULT_AMOUNT = 50_000;
    public MortgageLoan() {
        super(DEFAULT_INTEREST_RATE, DEFAULT_AMOUNT);
    }
}
