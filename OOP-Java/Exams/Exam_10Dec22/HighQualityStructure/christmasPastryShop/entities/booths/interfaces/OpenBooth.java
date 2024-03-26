package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.booths.interfaces;

public class OpenBooth extends BaseBooth {
    private static final double DEFAULT_PRICE_PER_PERSON = 2.50;
    public OpenBooth(int capacity, int numberOfPeople) {
        super(capacity, numberOfPeople, DEFAULT_PRICE_PER_PERSON);
    }
}
