package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T t);

}
