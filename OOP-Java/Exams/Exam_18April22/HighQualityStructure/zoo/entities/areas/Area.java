package Exams.Exam_18April22.HighQualityStructure.zoo.entities.areas;

import Exams.Exam_18April22.HighQualityStructure.zoo.entities.animals.Animal;
import Exams.Exam_18April22.HighQualityStructure.zoo.entities.foods.Food;

import java.util.Collection;

public interface Area {
    String getName();

    Collection<Animal> getAnimals();

    Collection<Food> getFoods();

    int sumCalories();

    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

    void addFood(Food food);

    void feed();

    String getInfo();
}
