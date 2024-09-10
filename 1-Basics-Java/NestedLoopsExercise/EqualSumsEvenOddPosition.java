package NestedLoopsExercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());


        for (int i = firstNumber; i <= secondNumber ; i++) {
            int currentNumber = i;
            int oddSum = 0;
            int evenSum = 0;

            for (int j = 6; j > 0 ; j--) {
                int lastDigit = currentNumber % 10;
                currentNumber /= 10;

                if (j % 2 == 0) {
                    evenSum += lastDigit;
                } else {
                    oddSum += lastDigit;
                }
            }

            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }

        }
    }
}
