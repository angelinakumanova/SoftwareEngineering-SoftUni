package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver;

import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
