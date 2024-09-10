package Exams.Exam_12April23.Magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {

    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        Cloth cloth = this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
        if (cloth != null) {
            this.data.remove(cloth);
            return true;
        }

        return false;
    }

    public Cloth getSmallestCloth() {
        return this.data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s magazine contains:%n", this.type)).trimToSize();

        this.data.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
