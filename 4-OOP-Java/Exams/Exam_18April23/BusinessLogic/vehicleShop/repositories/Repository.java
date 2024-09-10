package Exams.Exam_18April23.BusinessLogic.vehicleShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getWorkers();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
