package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parser = x -> Integer.parseInt(x);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(parser)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());
        int sum = numbers.stream().mapToInt(n -> n).sum();
        System.out.println("Sum = " + sum);
    }
}
