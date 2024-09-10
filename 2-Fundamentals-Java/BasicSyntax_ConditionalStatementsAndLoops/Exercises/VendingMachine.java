package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String insertCoins = scanner.nextLine();
            double sum = 0;
            boolean isEnoughMoney = false;

            while (!insertCoins.equals("Start")) {
                double money = Double.parseDouble(insertCoins);
                if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                    sum += money;
                } else {
                    System.out.printf("Cannot accept %.2f%n", money);
                }
                insertCoins = scanner.nextLine();
            }

            String insertProducts = scanner.nextLine();
            while (!insertProducts.equals("End")) {
                double sumOfProducts = 0;
                if (insertProducts.equals("Nuts") || insertProducts.equals("Water") || insertProducts.equals("Crisps")
                || insertProducts.equals("Soda") || insertProducts.equals("Coke")) {
                    switch (insertProducts) {
                        case "Nuts":
                            sumOfProducts += 2.0;
                            break;
                        case "Water":
                            sumOfProducts += 0.7;
                            break;
                        case "Crisps":
                            sumOfProducts += 1.5;
                            break;
                        case "Soda":
                            sumOfProducts += 0.8;
                            break;
                        case "Coke":
                            sumOfProducts += 1.0;
                            break;
                    }
                    if (sum >= sumOfProducts) {
                        System.out.printf("Purchased %s%n", insertProducts);
                        sum -= sumOfProducts;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else {
                    System.out.println("Invalid product");
                }
                insertProducts = scanner.nextLine();
            }
        System.out.printf("Change: %.2f", sum);
    }

}