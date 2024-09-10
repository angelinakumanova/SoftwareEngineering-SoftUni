package Polymorphism.Lab.WildFarm.animals.mammals.felime;

import Polymorphism.Lab.WildFarm.food.Food;
import Polymorphism.Lab.WildFarm.food.Meat;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
