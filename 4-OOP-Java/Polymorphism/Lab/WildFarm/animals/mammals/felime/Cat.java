package Polymorphism.Lab.WildFarm.animals.mammals.felime;

import Polymorphism.Lab.WildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.breed,
                df.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
