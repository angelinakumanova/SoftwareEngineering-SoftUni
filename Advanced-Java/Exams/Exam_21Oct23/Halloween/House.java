package Exams.Exam_21Oct23.Halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        Kid kid = this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (kid != null) {
            this.data.remove(kid);
            return true;
        }
        return false;
    }

    public Kid getKid(String street) {
        return this.data.stream().filter(e -> e.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:").append(System.lineSeparator());
        for (Kid kid : this.data) {
            sb.append(String.format("%s from %s street", kid.getName(), kid.getStreet()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
