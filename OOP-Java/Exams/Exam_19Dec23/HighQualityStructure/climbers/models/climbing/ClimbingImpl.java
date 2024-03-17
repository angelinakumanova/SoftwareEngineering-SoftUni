package Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climbing;

import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climber.Climber;
import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing {
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        for (Climber climber : climbers) {
            if (climber.canClimb()) {
                for (String peak : mountain.getPeaksList()) {
                    climber.getRoster().getPeaks().add(peak);
                    climber.climb();
                    mountain.getPeaksList().remove(peak);
                }
            }
        }
    }
}
