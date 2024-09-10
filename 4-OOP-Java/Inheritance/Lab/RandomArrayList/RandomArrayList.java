package Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public Object getRandomElement() {
        return super.remove(new Random().nextInt(super.size()));
    }
}
