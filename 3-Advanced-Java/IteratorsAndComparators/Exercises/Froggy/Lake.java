package IteratorsAndComparators.Exercises.Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{

    private int[] numbers;


    public Lake(int... numbers) {
        this.numbers = numbers;
    }

    public int length() {
        return numbers.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {

        int currentPos = 0;
        boolean evenIsPrinted = false;
        int end = numbers.length % 2 == 0 ? numbers.length - 2 : numbers.length - 1;
        @Override
        public boolean hasNext() {

            return currentPos < numbers.length;
        }

        @Override
        public Integer next() {
            int number = numbers[currentPos];
            if (currentPos == end && !evenIsPrinted) {
                currentPos = 1;
                evenIsPrinted = true;
            } else {
                currentPos = currentPos + 2;
            }

            return number;
        }
    }
}
