package Workshops.LabWorkshop;

import java.util.function.Consumer;

public class SmartStack {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public SmartStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            this.resize(this.capacity * 2);
        }
        this.items[this.size++] = element;
    }

    public int pop() {
        int val = this.items[this.size - 1];
        int[] temp = new int[this.capacity];
        System.arraycopy(this.items, 0, temp, 0, this.size - 1);
        this.items = temp;
        this.size--;

        if (this.size == this.capacity / 2) {
            this.shrink(this.capacity / 2);
        }

        return val;
    }

    public int peek() {
        return items[this.size - 1];
    }

    public int getSize() {
        return this.size;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }


    private void resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        System.arraycopy(this.items, 0, temp, 0, this.size);
        this.items = temp;
        this.capacity = newCapacity;
    }

    private void shrink(int newCapacity) {
        this.resize(newCapacity);
    }
}
