package Methods.Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println((getEvenNumbersSum(number)) * getOddNumbersSum(number));
    }

    public static int getEvenNumbersSum(int number) {
        String numberStr = String.valueOf(number);
        int evenSum = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number /= 10;
        }

        return evenSum;
    }
    public static int getOddNumbersSum (int number) {
        String numberStr = String.valueOf(number);
        int oddSum = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            number /= 10;
        }

        return oddSum;
    }

}
