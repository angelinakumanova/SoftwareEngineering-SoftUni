package Workshops.LabWorkshop;

import java.util.Set;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.resize(this.capacity * 2);
        }
        this.data[this.size++] = element;
    }

    public int get(int index) {
        validateIndex(index);
        return this.data[index];
    }

    public int remove(int index) {
        validateIndex(index);
        int val = this.data[index];
        int[] temp = new int[this.capacity];
        System.arraycopy(this.data, 0, temp, 0, index);
        System.arraycopy(this.data, index + 1, temp, index, this.size - (index + 1));
        this.data = temp;
        this.size--;

        if (this.size == this.capacity / 2) {
            this.shrink(this.capacity / 2);
        }

        return val;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        validateIndex(index);

        if (this.size + 1 == this.capacity) {
            this.resize(this.capacity * 2);
        }

        int[] temp = new int[this.capacity];

        System.arraycopy(this.data, 0, temp, 0, index);
        temp[index] = element;
        System.arraycopy(this.data, index, temp, index + 1, this.size - index);

        this.data = temp;
        this.size++;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        System.arraycopy(this.data, 0, temp, 0, this.size);
        this.data = temp;
        this.capacity = newCapacity;
    }

    private void shrink(int newCapacity) {
        this.resize(newCapacity);

    }
    private void validateIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException("Sorry!");
        }
    }
}
