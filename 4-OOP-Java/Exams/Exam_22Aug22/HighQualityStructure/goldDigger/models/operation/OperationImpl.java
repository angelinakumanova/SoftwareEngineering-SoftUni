package Exams.Exam_22Aug22.HighQualityStructure.goldDigger.models.operation;

import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.models.discoverer.Discoverer;
import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.List;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig()) {
                List<String> exhibits = (List<String>) spot.getExhibits();

                for (int i = 0; i < exhibits.size(); i++) {
                    discoverer.getMuseum().getExhibits().add(exhibits.get(i));
                    spot.getExhibits().remove(exhibits.get(i));
                    i--;
                }
            }
        }
    }
}
