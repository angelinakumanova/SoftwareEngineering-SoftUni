package Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}
