package whileLoopsExercises;

import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double desiredAmount = Double.parseDouble(scanner.nextLine());
        double sumPerCocktails;
        double totalSum = 0.0;

        String input = scanner.nextLine();
        while (!"Party!".equals(input)) {
            int cocktails = Integer.parseInt(scanner.nextLine());
            sumPerCocktails = input.length() * cocktails;

            if (sumPerCocktails % 2 != 0) {
                sumPerCocktails *= 0.75;
            }
            totalSum += sumPerCocktails;
            desiredAmount -= sumPerCocktails;
            if (desiredAmount <= 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if ("Party!".equals(input)) {
            System.out.printf("We need %.2f leva more.%n", desiredAmount);
        } else {
            System.out.println("Target acquired.");
        }
        System.out.printf("Club income - %.2f leva.", totalSum);
    }
}
