package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> firstSet = new TreeSet<>(new CompareByName());
        Set<Person> secondSet = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            firstSet.add(new Person(name, age));
            secondSet.add(new Person(name, age));
        }

        firstSet.forEach(System.out::println);
        secondSet.forEach(System.out::println);
    }
}
