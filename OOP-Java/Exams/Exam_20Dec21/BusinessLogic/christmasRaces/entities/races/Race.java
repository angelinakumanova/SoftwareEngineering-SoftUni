package Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.races;

import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
