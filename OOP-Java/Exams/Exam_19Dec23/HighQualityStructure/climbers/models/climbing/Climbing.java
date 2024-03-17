package Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climbing;

import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climber.Climber;
import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
