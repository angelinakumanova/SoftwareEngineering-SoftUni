package Exams.Exam_8April23.HighQualityStructure.robotService.entities.services;

import Exams.Exam_8April23.HighQualityStructure.robotService.entities.robot.Robot;
import Exams.Exam_8April23.HighQualityStructure.robotService.entities.supplements.Supplement;

import java.util.Collection;

public interface Service {
    String getName();

    void setName(String name);

    Collection<Robot> getRobots();

    Collection<Supplement> getSupplements();

    void addRobot(Robot robot);

    void removeRobot(Robot robot);

    void addSupplement(Supplement supplement);

    void feeding();

    int sumHardness();

    String getStatistics();
}
