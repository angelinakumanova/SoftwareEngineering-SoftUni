package NestedLoopsLab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int countCombo = 0;
        boolean isValid = false;

        for (int i = start; i <= end ; i++) {
            if (isValid) {
            break;
            }

            for (int j = start; j <= end; j++) {
                countCombo++;
                if ((i + j) == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", countCombo, i, j, magicNumber);
                    isValid = true;
                    break;
                }
            }

        }
        if (!isValid) {
            System.out.printf("%d combinations - neither equals %d", countCombo, magicNumber);
        }
    }
}
