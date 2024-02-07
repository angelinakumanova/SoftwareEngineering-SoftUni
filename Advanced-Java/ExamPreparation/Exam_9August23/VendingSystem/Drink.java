package Exams.Exam_9August23.VendingSystem;

import java.math.BigDecimal;

public class Drink {
    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Price: $" + this.price + ", Volume: " + this.volume + " ml";
    }
}
