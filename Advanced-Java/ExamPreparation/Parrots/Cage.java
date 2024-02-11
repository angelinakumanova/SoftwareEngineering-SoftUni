package ExamPreparation.Parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot parrot = this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (parrot != null) {
            this.data.remove(parrot);
            return true;
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (parrot != null) parrot.setAvailable(false);
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = this.data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());
        for (Parrot parrot : soldParrots) {
            parrot.setAvailable(false);
        }

        return soldParrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:", this.name)).append(System.lineSeparator());
        this.data.stream().filter(Parrot::isAvailable).forEach(p -> sb.append(p).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
