package Exams.Exam_9August23.VendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (getCount() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        Drink drink = this.drinks.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (drink != null) {
            this.drinks.remove(drink);
            return true;
        }
        return false;
    }

    public Drink getLongest() {
        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).orElse(null);
    }

    public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }

    public String buyDrink(String name) {
        return this.drinks.stream().filter(e -> e.getName().equals(name)).findFirst().toString();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:").append(System.lineSeparator());
        for (Drink drink : this.drinks) {
            sb.append(drink).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
