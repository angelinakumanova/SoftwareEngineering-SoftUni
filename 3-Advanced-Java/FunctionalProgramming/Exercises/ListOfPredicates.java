package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());
        List<Predicate<Integer>> divisorsPredicates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .map(divisor -> (Predicate<Integer>) num -> num % divisor == 0)
                .collect(Collectors.toList());

        Predicate<Integer> combinedPredicate = divisorsPredicates.stream().reduce(Predicate::and).orElse(x -> false);

        IntStream.range(1, range + 1).boxed().filter(combinedPredicate).forEach(e -> System.out.print(e + " "));
    }
}
