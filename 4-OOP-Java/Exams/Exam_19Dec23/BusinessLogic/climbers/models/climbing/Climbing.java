package Exams.Exam_19Dec23.BusinessLogic.climbers.models.climbing;

import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber.Climber;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
