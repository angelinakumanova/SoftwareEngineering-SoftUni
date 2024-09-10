package Exams.Exam_19Dec22.BusinessLogic.magicGame.repositories.interfaces;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
