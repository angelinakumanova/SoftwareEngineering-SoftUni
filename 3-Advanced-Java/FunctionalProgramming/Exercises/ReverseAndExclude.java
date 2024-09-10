package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> reverseList = l -> {
            List<Integer> newList = new ArrayList<>();
            for (int i = l.size() - 1; i >= 0 ; i--) {
                newList.add(l.get(i));
            }
            return newList;
        };

        list = reverseList.apply(list);

        int divider = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> filterIfDivisible = n -> n % divider != 0;

        Consumer<Integer> printList = n -> {
            System.out.print(n + " ");
        };

        list.stream().filter(filterIfDivisible).forEach(printList);



    }
}
