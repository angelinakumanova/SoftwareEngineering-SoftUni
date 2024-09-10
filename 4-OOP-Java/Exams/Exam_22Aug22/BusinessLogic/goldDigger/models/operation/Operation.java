package Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.operation;

import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Discoverer;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
