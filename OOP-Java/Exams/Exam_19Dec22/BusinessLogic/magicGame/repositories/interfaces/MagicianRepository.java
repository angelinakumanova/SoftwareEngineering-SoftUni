package Exams.Exam_19Dec22.BusinessLogic.magicGame.repositories.interfaces;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
