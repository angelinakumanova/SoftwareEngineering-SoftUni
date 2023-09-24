package DataTypesAndVariables.Exercises.MoreExercises;

import java.util.Scanner;

public class Refactoring_PrimeChecker {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int range = Integer.parseInt(scanner.nextLine());

    for (int i = 2; i <= range; i++) {
        boolean isPrime = true;

        for (int number = 2; number < i; number++) {
            if (i % number == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.printf("%d -> %b%n", i, isPrime);
        }
    }

}
