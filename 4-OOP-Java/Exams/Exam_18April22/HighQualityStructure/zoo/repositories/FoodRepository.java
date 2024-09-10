package Exams.Exam_18April22.HighQualityStructure.zoo.repositories;

import Exams.Exam_18April22.HighQualityStructure.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
