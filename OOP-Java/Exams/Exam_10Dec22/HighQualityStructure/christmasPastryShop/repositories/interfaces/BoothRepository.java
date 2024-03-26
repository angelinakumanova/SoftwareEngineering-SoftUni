package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
