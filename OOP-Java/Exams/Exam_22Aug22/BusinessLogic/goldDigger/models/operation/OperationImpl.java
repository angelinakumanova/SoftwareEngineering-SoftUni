package Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.operation;

import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Discoverer;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> spotExhibits = spot.getExhibits();

        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && spotExhibits.iterator().hasNext()) {
                discoverer.dig();

                String currentExhibit = spotExhibits.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentExhibit);
                spotExhibits.remove(currentExhibit);
            }
        }
    }
}
