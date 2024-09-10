package Exams.Exam_20Dec21.BusinessLogic.christmasRaces.repositories;

import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.drivers.Driver;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }
    @Override
    public Driver getByName(String name) {
        return this.drivers.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.drivers);
    }

    @Override
    public void add(Driver driver) {
        this.drivers.add(driver);
    }

    @Override
    public boolean remove(Driver driver) {
        if (this.drivers.contains(driver)) {
            this.drivers.remove(driver);
            return true;
        }
        return false;
    }
}
