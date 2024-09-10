package ExamPreparation.Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (!this.fishInPool.contains(fish) && this.fishInPool.size() < this.capacity) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish fish = this.fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
        if (fish != null) {
            this.fishInPool.remove(fish);
            return true;
        }
        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %s", this.name, this.size)).append(System.lineSeparator());
        this.fishInPool.forEach(f -> sb.append(f).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
