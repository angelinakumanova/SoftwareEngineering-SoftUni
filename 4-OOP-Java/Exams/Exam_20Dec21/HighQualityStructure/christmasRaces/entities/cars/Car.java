package Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}
