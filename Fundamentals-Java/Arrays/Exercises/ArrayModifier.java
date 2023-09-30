package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while(!input.equals("end")) {
            if (input.contains("swap")) {
                int firstIndex = Integer.parseInt(input.split(" ")[1]);
                int secondIndex = Integer.parseInt(input.split(" ")[2]);

                int firstIndexNumber = numbers[firstIndex];
                int secondIndexNumber = numbers[secondIndex];

                numbers[firstIndex] = secondIndexNumber;
                numbers[secondIndex] = firstIndexNumber;
            } else if (input.contains("multiply")) {
                int firstIndex = Integer.parseInt(input.split(" ")[1]);
                int secondIndex = Integer.parseInt(input.split(" ")[2]);

                int firstIndexNumber = numbers[firstIndex];
                int secondIndexNumber = numbers[secondIndex];

                int product = firstIndexNumber * secondIndexNumber;
                numbers[firstIndex] = product;
            } else if (input.equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]--;
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i] + " ");
                break;
            }
            System.out.print(numbers[i] + "," + " ");
        }
    }
}
