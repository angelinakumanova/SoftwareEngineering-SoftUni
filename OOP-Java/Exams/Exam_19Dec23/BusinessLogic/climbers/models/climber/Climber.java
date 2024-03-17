package Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber;

import Exams.Exam_19Dec23.BusinessLogic.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();


    void climb();
}
