package Generics.Exercises.GenericCountMethodDoubles;

public class Box<E extends Comparable<E>> implements Comparable<Box<E>> {

    private E element;

    public Box(E element) {
        this.element = element;
    }



    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }

    @Override
    public int compareTo(Box<E> o) {
        return this.element.compareTo(o.element);
    }


}
