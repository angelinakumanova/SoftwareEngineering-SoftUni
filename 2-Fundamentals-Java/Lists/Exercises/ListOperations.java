package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {



            if (input.contains("Add")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                numbers.add(number);
            } else if (input.contains("Insert")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                int index = Integer.parseInt(input.split(" ")[2]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.add(index, number);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (input.contains("Remove")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.remove(index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (input.contains("Shift left")) {
                int count = Integer.parseInt(input.split(" ")[2]);
                for (int i = 0; i < count; i++) {
                    numbers.add(numbers.get(0));
                    numbers.remove(0);
                }
            } else if (input.contains("Shift right")) {
                int count = Integer.parseInt(input.split(" ")[2]);
                for (int i = 0; i < count; i++) {
                    int lastElement = numbers.get(numbers.size() - 1);
                    numbers.add(0, lastElement);
                    numbers.remove(numbers.size() - 1);
                }
            }
            input = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
