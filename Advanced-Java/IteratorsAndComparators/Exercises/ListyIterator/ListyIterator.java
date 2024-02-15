package IteratorsAndComparators.Exercises.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

    private List<T> elements;
    private int index;
    private Iterator<T> listyIterator;

    public ListyIterator(T... elements) {
        this.elements = List.of(elements);
        this.index = 0;
        this.listyIterator = iterator();
    }

    public boolean move() {
        if (listyIterator.hasNext()) {
            index++;
            listyIterator.next();
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return listyIterator.hasNext();
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.elements.get(index));
    }

    public void printAll() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        this.elements.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < elements.size() - 1;
            }

            @Override
            public T next() {
                return elements.get(idx++);
            }
        };
    }
}
