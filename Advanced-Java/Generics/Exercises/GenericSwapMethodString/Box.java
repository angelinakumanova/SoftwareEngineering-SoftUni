package Generics.Exercises.GenericSwapMethodString;

import java.util.List;

public class Box<E> {

    private E element;

    public Box(E element) {
        this.element = element;
    }



    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }
}
