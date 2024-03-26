package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
