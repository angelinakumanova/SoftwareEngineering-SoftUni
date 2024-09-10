package Methods.Exercises;

import java.util.Scanner;

public class TopNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        checkForTopNumbers(n);
    }


    public static void checkForTopNumbers (int n) {

        for (int i = 1; i <= n ; i++) {
            boolean isTopNumber = false;
            int counter = 0;
            int sumOfDigits = 0;
            String digitLength = String.valueOf(i);
            int currentNumber = i;

            for (int j = 1; j <= digitLength.length(); j++) {
                int digit = 0;
                digit = currentNumber % 10;

                sumOfDigits += digit;
                if (sumOfDigits % 8 == 0 && j == digitLength.length()) {
                    isTopNumber = true;
                }


                if (digit % 2 != 0) {
                    counter++;
                }
                currentNumber /= 10;
            }
            if (isTopNumber && counter >= 1) {
                System.out.println(i);
            }
        }
    }
}
