package Exams.Exam_22Aug22.HighQualityStructure.goldDigger.models.discoverer;

import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.models.museum.Museum;

public interface Discoverer {
    String getName();

    double getEnergy();

    boolean canDig();

    Museum getMuseum();

    void dig();
}
