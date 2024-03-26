package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.booths.interfaces;

public class PrivateBooth extends BaseBooth {
    private static final double DEFAULT_PRICE_PER_PERSON = 3.50;
    public PrivateBooth(int capacity, int numberOfPeople) {
        super(capacity, numberOfPeople, DEFAULT_PRICE_PER_PERSON);
    }
}
