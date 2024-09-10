package Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        if (numbers.size() % 2 != 0) {
            int midIndex = numbers.size() / 2;
            numbers.add(midIndex, 0);
        }

        for (int i = 0; i < numbers.size() / 2; i++) {
            int leftElement = numbers.get(i);
            int rightElement = numbers.get(numbers.size() - 1 - i);

            result.add((leftElement + rightElement));
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
