package Exams.Exam_18Feb23.Kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChild(String firstName) {
        Child child = this.registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
        if (child != null) {
            this.registry.remove(child);
            return true;
        }

        return false;
    }
    public int getChildrenCount() {
        return this.registry.size();
    }
    public Child getChild(String firstName) {
        return this.registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }
    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", this.name));
       this.registry.stream().sorted(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName))
                .forEach(e -> {
                   sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
                   sb.append(e.toString());
               });


        return sb.toString().trim();
    }
}
