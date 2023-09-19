package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flower = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0.0;
        switch (flower) {
            case "Roses":
                price = n * 5;
                if (n > 80) {
                    price = price * 0.90;
                }
                break;
            case "Dahlias":
                price = n * 3.80;
                if (n > 90) {
                    price = price * 0.85;
                }
                break;
            case "Tulips":
                price = n * 2.80;
                if (n > 80) {
                    price = price * 0.85;
                }
                break;
            case "Narcissus":
                price = n * 3;
                if (n < 120) {
                    price = price * 1.15;
                }
                break;
            case "Gladiolus":
                price = n * 2.50;
                if (n < 80) {
                    price = price * 1.20;
                }
                break;
            }
            if (budget >= price) {
            price = budget - price;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", n, flower, price);
            } else if (price > budget) {
            price = price - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", price);
             }
    }
}
