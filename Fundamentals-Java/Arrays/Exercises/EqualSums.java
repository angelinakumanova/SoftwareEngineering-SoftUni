package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            int leftSum = 0;
            int rightSum = 0;

            for (int left = 0; left < i; left++) {
                leftSum += numbers[left];
            }
            for (int right = i + 1; right < numbers.length; right++) {
                rightSum += numbers[right];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
