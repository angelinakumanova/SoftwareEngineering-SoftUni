package Inheritance.Exercises.Restaraunt.food.main_dish;

import Inheritance.Exercises.Restaraunt.food.Food;

import java.math.BigDecimal;

public class MainDish extends Food {
    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
