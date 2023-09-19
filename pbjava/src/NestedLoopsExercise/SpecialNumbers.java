package NestedLoopsExercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1111; i <= 9999; i++) {
            int currentNum = i;
            int count = 0;

            for (int j = 0; j < 4; j++) {
                int lastDigit = currentNum % 10;
                currentNum /= 10;

                if (lastDigit == 0) {
                    break;
                }

                if (n % lastDigit == 0) {
                    count++;
                }
            }

            if (count == 4) {
                System.out.print(i + " ");
            }
        }
    }
}
