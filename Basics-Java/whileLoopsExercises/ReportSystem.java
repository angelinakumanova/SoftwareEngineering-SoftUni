package whileLoopsExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expectedSum = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int countCards = 0;
        int countCash = 0;
        double totalSumCard= 0;
        double totalSumCash = 0;

        while (expectedSum > 0) {
            String input = scanner.nextLine();
            if ("End".equals(input)) {
                break;
            }
            int priceOfItems = Integer.parseInt(input);
            count++;

            if (count % 2 == 0) { // paying with card
                if (priceOfItems < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    expectedSum -= priceOfItems;
                    totalSumCard += priceOfItems;
                    countCards++;
                }
            } else { // paying in cash
                if (priceOfItems > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                        expectedSum -= priceOfItems;
                        totalSumCash += priceOfItems;
                        countCash++;
                }
            }
        }
        if (expectedSum > 0) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f%n", totalSumCash / countCash);
            System.out.printf("Average CC: %.2f", totalSumCard / countCards);
        }
    }
}
