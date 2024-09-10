package Polymorphism.Lab.WildFarm.animals.mammals;

import Polymorphism.Lab.WildFarm.food.Food;
import Polymorphism.Lab.WildFarm.food.Vegetable;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");;
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
