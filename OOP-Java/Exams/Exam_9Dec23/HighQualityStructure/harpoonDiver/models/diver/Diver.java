package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.diver;

import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
