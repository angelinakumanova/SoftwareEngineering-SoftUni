package Exams.Exam_5Aug23.HighQualityStructure.bank.entities.bank;

public class BranchBank extends BaseBank {
    private static final int DEFAULT_CAPACITY = 25;

    public BranchBank(String name) {
        super(name, DEFAULT_CAPACITY);
    }
}
