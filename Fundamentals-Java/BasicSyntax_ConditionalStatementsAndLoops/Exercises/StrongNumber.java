package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int numberInside = Integer.parseInt(number);
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            int digit = numberInside % 10;
            int digitSum = 1;

            for (int j = 1; j <= digit; j++) {
                digitSum = digitSum * j;

            }
            sum += digitSum;
            numberInside /= 10;

        }
        if (Integer.parseInt(number) == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
