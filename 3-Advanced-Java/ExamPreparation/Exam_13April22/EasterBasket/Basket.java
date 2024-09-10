package ExamPreparation.Exam_13April22.EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        Egg egg = this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
        if (egg != null) {
            this.data.remove(egg);
            return true;
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", this.material)).append(System.lineSeparator());
        this.data.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
