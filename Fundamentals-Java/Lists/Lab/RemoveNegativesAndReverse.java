package Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputElements = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();


        for (String element : inputElements) {
            int number = Integer.parseInt(element);
            if (number > 0) {
                numbers.add(number);
            }
        }

        Collections.reverse(numbers);

        if (numbers.size() == 0) {
            System.out.println("empty");
        } else {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
