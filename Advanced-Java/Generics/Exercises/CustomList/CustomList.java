package Generics.Exercises.CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        validateIndex(index);
        T element = this.data.get(index);
        this.data.remove(index);

        return element;
    }

    public boolean contains(T element) {
        if (this.data.contains(element)) {
            return true;
        }

        return false;
    }

    public void swap(int firstIdx, int secondIdx) {
        validateIndex(firstIdx);
        validateIndex(secondIdx);

        T firstElement = this.data.get(firstIdx);
        this.data.set(firstIdx, this.data.get(secondIdx));
        this.data.set(secondIdx, firstElement);

    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T el : this.data) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        return this.data.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return this.data.stream().min(Comparator.naturalOrder()).get();
    }

    public void print() {
        this.data.forEach(System.out::println);
    }
    private void validateIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException();
        }
    }
}
