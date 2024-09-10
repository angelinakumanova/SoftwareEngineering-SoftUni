package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCondition = Integer.parseInt(scanner.nextLine());
        Predicate<String> filterFactory = s -> s.length() <= lengthCondition;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(filterFactory)
                .forEach(System.out::println);
    }
}
