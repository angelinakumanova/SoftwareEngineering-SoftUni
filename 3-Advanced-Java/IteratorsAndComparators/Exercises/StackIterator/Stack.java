package IteratorsAndComparators.Exercises.StackIterator;


import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    private Integer[] elements;
    private int internalIndex;

    public Stack() {
        this.elements = new Integer[16];
        internalIndex = -1;
    }

    public void push(Integer element) {
        this.elements[++internalIndex] = element;
    }

    public void pop() {
        if (internalIndex == -1) {
            throw new IllegalStateException("No elements");
        }
        this.elements[internalIndex--] = null;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int idx = internalIndex;
            @Override
            public boolean hasNext() {
                return idx >= 0;
            }

            @Override
            public Integer next() {
                return elements[idx--];
            }
        };
    }
}
