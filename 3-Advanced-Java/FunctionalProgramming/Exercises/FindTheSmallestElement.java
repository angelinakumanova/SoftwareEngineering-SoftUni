package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallestEl = l -> {
            int smallestNum = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) <= smallestNum) {
                    smallestNum = l.get(i);
                    idx = i;
                }
            }

            return idx;
        };
        System.out.println(getSmallestEl.apply(numbers));
    }
}
