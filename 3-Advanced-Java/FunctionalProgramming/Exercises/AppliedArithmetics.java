package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer[]> addFunc = a -> {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] + 1;
            }
            return a;
        };
        Function<Integer[], Integer[]> multiplyFunc = a -> {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
            }
            return a;
        };
        Function<Integer[], Integer[]> subtractFunc = a -> {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] - 1;
            }
            return a;
        };
        Consumer<Integer[]> printArr = a -> {
            for (Integer i : a) {
                System.out.print(i + " ");
            }
        };

        BiFunction<String, Integer[], Integer[]> calculateFunc = (s, a) -> {
            switch (s) {
                case "add":
                    return addFunc.apply(a);
                case "multiply":
                    return multiplyFunc.apply(a);
                case "subtract":
                    return subtractFunc.apply(a);
                default:
                    return a;
            }
        };

        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            if (input.equals("print")) {
                printArr.accept(array);
                System.out.println();
            } else {
                calculateFunc.apply(input, array);
            }

            input = scanner.nextLine();
        }
    }
}
