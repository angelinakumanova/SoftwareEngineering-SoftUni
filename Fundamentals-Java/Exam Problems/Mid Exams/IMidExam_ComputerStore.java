package ExamProblems;

import java.util.Scanner;

public class IMidExam_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double prices = Double.parseDouble(input);
            if (prices < 0) {
                System.out.println("Invalid price!");
            } else {
                sum += prices;
            }


            input = scanner.nextLine();
        }
        double sumWithTaxes = (sum * 0.2) + sum;
        double amountOfTaxes = sum * 0.2;

        if (sumWithTaxes == 0) {
            System.out.println("Invalid order!");
        }
        if (input.equals("special") && sumWithTaxes > 0) {
            sumWithTaxes = sumWithTaxes - (sumWithTaxes * 0.1);
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", sum, amountOfTaxes, sumWithTaxes);
        } else if (input.equals("regular") && sumWithTaxes > 0){
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", sum, amountOfTaxes, sumWithTaxes);
        }
    }

}
