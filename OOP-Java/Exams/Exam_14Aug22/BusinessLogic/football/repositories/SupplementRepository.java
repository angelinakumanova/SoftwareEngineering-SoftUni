package Exams.Exam_14Aug22.BusinessLogic.football.repositories;

import Exams.Exam_14Aug22.BusinessLogic.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
