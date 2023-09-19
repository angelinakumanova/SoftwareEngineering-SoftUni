package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int nfishermen = Integer.parseInt(scanner.nextLine());

        double pricerent = 0;

        switch (season) {
            case "Spring":
                pricerent = 3000;
                break;
            case "Summer":
            case "Autumn":
                pricerent = 4200;
                break;
            case "Winter":
                pricerent = 2600;
                break;
        }

        if (nfishermen <= 6) {
            pricerent *= 0.90;
        } else if (nfishermen <= 11) {
            pricerent *= 0.85;
        } else {
            pricerent *= 0.75;
        }

        if (nfishermen % 2 == 0 && !season.equals("Autumn")) {
            pricerent *= 0.95;
        }

        if (budget >= pricerent) {
            pricerent = budget - pricerent;
            System.out.printf("Yes! You have %.2f leva left.", pricerent);
        } else if (pricerent > budget) {
            pricerent = pricerent - budget;
            System.out.printf("Not enough money! You need %.2f leva.", pricerent);
        }
    }
}
