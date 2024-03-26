package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces;

public interface CocktailRepository<T> extends Repository<T> {
    T getByName(String name);
}
