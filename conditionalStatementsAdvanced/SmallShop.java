package conditionalStatementsAdvanced;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;
        if (town.equals("Sofia")) {
            switch (product) {
                case "coffee":
                    price = 0.5 * quantity;
                    break;
                case "water":
                    price = 0.8 * quantity;
                    break;
                case "beer":
                    price = 1.20 * quantity;
                    break;
                case "sweets":
                    price = 1.45 * quantity;
                    break;
                case "peanuts":
                    price = 1.60 * quantity;
                    break;

            }
        } else if (town.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    price = 0.4 * quantity;
                    break;
                case "water":
                    price = 0.7 * quantity;
                    break;
                case "beer":
                    price = 1.15 * quantity;
                    break;
                case "sweets":
                    price = 1.30 * quantity;
                    break;
                case "peanuts":
                    price = 1.50 * quantity;
                    break;

            }
        } else if (town.equals("Varna")) {
            switch (product) {
                case "coffee":
                    price = 0.45 * quantity;
                    break;
                case "water":
                    price = 0.7 * quantity;
                    break;
                case "beer":
                    price = 1.10 * quantity;
                    break;
                case "sweets":
                    price = 1.35 * quantity;
                    break;
                case "peanuts":
                    price = 1.55 * quantity;
                    break;

            }
        }
        System.out.println(price);
    }
}

