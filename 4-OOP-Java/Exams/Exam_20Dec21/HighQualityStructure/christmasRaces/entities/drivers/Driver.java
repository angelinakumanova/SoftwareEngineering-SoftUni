package Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.drivers;

import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
