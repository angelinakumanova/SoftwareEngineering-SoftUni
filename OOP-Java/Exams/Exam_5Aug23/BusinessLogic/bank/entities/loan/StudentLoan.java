package Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan;

public class StudentLoan extends BaseLoan {
    private static final int DEFAULT_INTEREST_RATE = 1;
    private static final double DEFAULT_AMOUNT = 10_000;
    public StudentLoan() {
        super(DEFAULT_INTEREST_RATE, DEFAULT_AMOUNT);
    }
}
