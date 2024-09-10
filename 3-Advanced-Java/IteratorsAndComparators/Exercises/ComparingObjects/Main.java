package IteratorsAndComparators.Exercises.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person p = new Person(name, age, town);
            people.add(p);

            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine()) - 1;
        Person personToCompare = people.get(n);

        int equalPeople = 0;
        int notEqual = 0;

        for (int i = 0; i < people.size(); i++) {
            if (i != n) {
                if (people.get(i).compareTo(personToCompare) == 0) {
                    equalPeople++;
                } else {
                    notEqual++;
                }
            }

        }

        if (equalPeople == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(equalPeople + 1 + " " + notEqual + " " + people.size());
        }

    }
}
