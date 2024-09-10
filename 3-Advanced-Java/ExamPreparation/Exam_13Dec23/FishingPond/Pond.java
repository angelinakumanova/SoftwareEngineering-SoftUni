package Exams.Exam_13Dec23.FishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (this.fishes.size() < this.capacity) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish : fishes) {
            if (fish.getSpecies().equals(species)) {
                fishes.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish getOldestFish() {
        return this.fishes.stream().max(Comparator.comparing(Fish::getAge)).orElse(null);
    }

    public Fish getFish(String species) {
        return this.fishes.stream().filter(f -> f.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        String text = "Fishes in the pond:\n";
        sb.append(text);
        this.fishes.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
