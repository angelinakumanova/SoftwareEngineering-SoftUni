package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers.toString().replaceAll("[\\[\\]]", ""));

        List<Integer> sortedNumbers = evenNumbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
