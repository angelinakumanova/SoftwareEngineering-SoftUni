package IteratorsAndComparators.Exercises.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Stack stack = new Stack();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Push":
                    input = input.replaceAll("Push ", "");
                    Arrays.stream(input.split(",\\s+"))
                            .map(Integer::parseInt)
                            .forEach(stack::push);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }


            input = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
