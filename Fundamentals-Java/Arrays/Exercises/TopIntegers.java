package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            boolean isBigger = true;

            for (int j = i + 1; j <= numbers.length - 1; j++) {
                int numberAfter = numbers[j];
                if (currentNumber <= numberAfter) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
