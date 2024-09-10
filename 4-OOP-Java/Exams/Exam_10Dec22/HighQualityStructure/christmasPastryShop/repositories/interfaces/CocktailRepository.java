package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces;

public interface CocktailRepository<T> extends Repository<T> {
    T getByName(String name);
}
