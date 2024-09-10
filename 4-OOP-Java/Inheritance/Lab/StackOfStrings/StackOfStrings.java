package Inheritance.Lab.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings(List<String> data) {
        this.data = data;
    }

    public StackOfStrings() {
        this(new ArrayList<>());
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        return this.data.isEmpty() ? null : this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        return this.data.isEmpty() ? null : this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
