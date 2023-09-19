package exams;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOfTShirt = Double.parseDouble(scanner.nextLine());
        double desiredSum = Double.parseDouble(scanner.nextLine());

        double shortsPrice = 75 / 100.0 * priceOfTShirt;
        double socksPrice = 20 / 100.0 * shortsPrice;
        double shoesPrice = 2 * (priceOfTShirt + shortsPrice);
        double sum = priceOfTShirt + shoesPrice + shortsPrice + socksPrice;
        double sumWithDiscount = sum * 0.85;

        if (sumWithDiscount >= desiredSum) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", sumWithDiscount);
        } else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", desiredSum - sumWithDiscount);
        }

    }
}
