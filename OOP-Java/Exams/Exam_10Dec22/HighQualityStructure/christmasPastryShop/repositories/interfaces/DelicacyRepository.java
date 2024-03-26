package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);
}
