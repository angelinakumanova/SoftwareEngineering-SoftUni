package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //2, 3, 6, 7, 10

        boolean isDivisible = false;
        boolean IsNotDivisible = false;

        while (!isDivisible && !IsNotDivisible) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 10 == 0) {
                System.out.println("The number is divisible by 10");
                isDivisible = true;
            } else if (number % 7 == 0) {
                System.out.println("The number is divisible by 7");
                isDivisible = true;
            } else if (number % 6 == 0) {
                System.out.println("The number is divisible by 6");
                isDivisible = true;
            } else if (number % 3 == 0) {
                System.out.println("The number is divisible by 3");
                isDivisible = true;
            } else if (number % 2 == 0) {
                System.out.println("The number is divisible by 2");
                isDivisible = true;
            } else {
                System.out.println("Not divisible");
                IsNotDivisible = true;
            }
        }
    }
}
