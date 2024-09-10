package Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climber;

import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();


    void climb();
}
