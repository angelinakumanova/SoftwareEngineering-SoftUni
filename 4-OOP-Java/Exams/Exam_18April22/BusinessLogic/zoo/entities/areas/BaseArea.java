package Exams.Exam_18April22.BusinessLogic.zoo.entities.areas;

import Exams.Exam_18April22.BusinessLogic.zoo.entities.animals.Animal;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static Exams.Exam_18April22.BusinessLogic.zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static Exams.Exam_18April22.BusinessLogic.zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(this.foods);
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(this.animals);
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.animals.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : this.animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        info.append(String.format("Animals: %s", this.animals.isEmpty() ? "none" :
                this.animals.stream().map(Animal::getName).collect(Collectors.joining(" "))))
                .append(System.lineSeparator());
        info.append(String.format("Foods: %d", this.foods.size())).append(System.lineSeparator());
        info.append(String.format("Calories: %d", this.sumCalories()));

        return info.toString();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
