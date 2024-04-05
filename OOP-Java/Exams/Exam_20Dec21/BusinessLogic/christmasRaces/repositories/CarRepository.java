package Exams.Exam_20Dec21.BusinessLogic.christmasRaces.repositories;

import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.cars.Car;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return this.cars.stream().filter(c -> c.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }

    @Override
    public void add(Car car) {
        this.cars.add(car);
    }

    @Override
    public boolean remove(Car car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
            return true;
        }
        return false;
    }
}
