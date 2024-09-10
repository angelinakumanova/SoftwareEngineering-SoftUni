package Exams.Exam_15Aug23.HighQualityStructure.handball.repositories;

import Exams.Exam_15Aug23.HighQualityStructure.handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
