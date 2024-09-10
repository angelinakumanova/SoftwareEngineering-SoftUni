package IteratorsAndComparators.Exercises.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator<String> listyIterator = new ListyIterator<>();
        while (!"END".equals(input)) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Create":
                    String[] elements = Arrays.stream(input.split("\\s+")).skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator<>(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException isx) {
                        System.out.println(isx.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        listyIterator.printAll();
                    } catch (IllegalStateException isx) {
                        System.out.println(isx.getMessage());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
