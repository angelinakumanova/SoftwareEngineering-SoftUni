package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int compare = Integer.compare(p1.getName().length(), p2.getName().length());

        if (compare == 0) {
            compare = Integer.compare(p1.getName().toLowerCase().charAt(0), p2.getName().toLowerCase().charAt(0));
        }
        return compare;
    }
}
