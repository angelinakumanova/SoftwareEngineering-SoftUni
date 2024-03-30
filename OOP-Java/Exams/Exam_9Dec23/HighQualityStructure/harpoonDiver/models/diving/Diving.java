package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.diving;

import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.diver.Diver;
import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {

    void searching(DivingSite divingSite, Collection<Diver> divers);
}
