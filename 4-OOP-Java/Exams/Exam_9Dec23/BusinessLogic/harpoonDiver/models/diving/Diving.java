package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diving;

import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver.Diver;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {

    void searching(DivingSite divingSite, Collection<Diver> divers);
}
