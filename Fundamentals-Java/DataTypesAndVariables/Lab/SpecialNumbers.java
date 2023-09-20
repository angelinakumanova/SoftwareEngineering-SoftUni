package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;

            while (number > 0) {
                int lastDigit = number % 10;
                sum += lastDigit;
                number /= 10;
            }
            boolean isSpecial = sum == 5 || sum == 7 || sum == 11;
            if (isSpecial) {
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }
        }
    }
}
