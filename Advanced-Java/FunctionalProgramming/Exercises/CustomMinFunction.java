package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findMin = n -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n.length; i++) {
                if (n[i] < min) {
                    min = n[i];
                }
            }
            return min;
        };

        Integer[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int min = findMin.apply(array);
        System.out.println(min);
    }
}
