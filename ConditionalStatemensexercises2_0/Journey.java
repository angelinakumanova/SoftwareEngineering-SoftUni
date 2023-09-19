package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        boolean validSeason = "summer".equals(season) || "winter".equals(season);
        String destination = "";

        double price = 0.0;

        if (budget <= 100) {
            destination = "Bulgaria";
            switch (season) {
                case "summer":
                    price = 30 / 100.0 * budget;
                    break;
                case "winter":
                    price = 70 / 100.0 * budget;
                    break;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            price = 90 / 100.0 * budget;
        } else {
            destination = "Balkans";
            switch (season) {
                case "summer":
                    price = 40 / 100.0 * budget;
                    break;
                case "winter":
                    price = 80 / 100.0 * budget;
                    break;

            }
        } String type = "";
        if (destination.equals("Europe") || season.equals("winter")) {
            type = "Hotel";
        } else {
            type = "Camp";
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", type, price);
    }
}
