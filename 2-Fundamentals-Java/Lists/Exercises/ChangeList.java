package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {

            if (input.contains("Delete")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i).equals(number)) {
                        numbers.remove(Integer.valueOf(number));
                    }
                }
            } else if (input.contains("Insert")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                int index = Integer.parseInt(input.split(" ")[2]);

                numbers.add(index, number);
            }

            input = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
