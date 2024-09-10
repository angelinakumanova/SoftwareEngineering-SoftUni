package Exams.Exam_8April23.HighQualityStructure.robotService.repositories;

import Exams.Exam_8April23.HighQualityStructure.robotService.entities.supplements.Supplement;

public interface Repository {

    void addSupplement(Supplement supplement);

    boolean removeSupplement(Supplement supplement);

    Supplement findFirst(String type);
}
