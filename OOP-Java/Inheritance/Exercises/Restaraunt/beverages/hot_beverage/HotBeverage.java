package Inheritance.Exercises.Restaraunt.beverages.hot_beverage;

import Inheritance.Exercises.Restaraunt.beverages.Beverage;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {
    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
