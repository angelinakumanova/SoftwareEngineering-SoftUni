package IteratorsAndComparators.Exercises.Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Lake lake = new Lake();
        while (!"END".equals(input)) {
            lake = new Lake(Arrays.stream(input.split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray());

            input = scanner.nextLine();
        }

        Iterator<Integer> iterator = lake.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            System.out.print(element);

            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }
    }
}
