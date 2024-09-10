package conditionalStatementsAdvanced;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        boolean validWorkingDays = "Monday".equals(dayOfTheWeek) || "Tuesday".equals(dayOfTheWeek)
                || "Wednesday".equals(dayOfTheWeek) || "Thursday".equals(dayOfTheWeek) || "Friday".equals(dayOfTheWeek);
        boolean validWeekend = "Saturday".equals(dayOfTheWeek) || "Sunday".equals(dayOfTheWeek);
        boolean validFruit = "banana".equals(fruit) || "apple".equals(fruit) || "orange".equals(fruit)
                || "grapefruit".equals(fruit) || "kiwi".equals(fruit) || "pineapple".equals(fruit)
                || "grapes".equals(fruit);
        boolean validWeekOfTheDay = validWorkingDays || validWeekend;


        if (!validWeekOfTheDay || !validFruit) {
            System.out.println("error");
        } else {
            double price = 0;
            if (validWorkingDays) {
                switch (fruit) {
                    case "banana":
                        price = 2.50 * quantity;
                        break;
                    case "apple":
                        price = 1.20 * quantity;
                        break;
                    case "orange":
                        price = 0.85 * quantity;
                        break;
                    case "grapefruit":
                        price = 1.45 * quantity;
                        break;
                    case "kiwi":
                        price = 2.70 * quantity;
                        break;
                    case "pineapple":
                        price = 5.50 * quantity;
                        break;
                    case "grapes":
                        price = 3.85 * quantity;
                        break;
                }
            } else if (validWeekend) {
                switch (fruit) {
                    case "banana":
                        price = 2.70 * quantity;
                        break;
                    case "apple":
                        price = 1.25 * quantity;
                        break;
                    case "orange":
                        price = 0.90 * quantity;
                        break;
                    case "grapefruit":
                        price = 1.60 * quantity;
                        break;
                    case "kiwi":
                        price = 3.00 * quantity;
                        break;
                    case "pineapple":
                        price = 5.60 * quantity;
                        break;
                    case "grapes":
                        price = 4.20 * quantity;
                        break;
                }
            }
            System.out.printf("%.2f", price);
        }

    }
}
