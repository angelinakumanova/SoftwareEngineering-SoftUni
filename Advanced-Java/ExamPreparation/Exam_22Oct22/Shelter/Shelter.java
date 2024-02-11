package ExamPreparation.Exam_22Oct22.Shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        Animal animal = this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (animal != null) {
            this.data.remove(animal);
            return true;
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream()
                .filter(e -> e.getName().equals(name) && e.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        this.data.forEach(animal -> sb.append(String.format("%s %s", animal.getName(), animal.getCaretaker()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"The shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}
}
