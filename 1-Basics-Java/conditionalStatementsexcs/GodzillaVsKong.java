package conditionalStatementsexcs;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Ред 1.Бюджет за филма – реално число в интервала [1.00 … 1000000.00]
        //Ред 2.Брой на статистите – цяло число в интервала [1 … 500]
        //Ред 3.Цена за облекло на един статист – реално число в интервала [1.00 … 1000.00]

        double moviebudget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double priceofacostume = Double.parseDouble(scanner.nextLine());

        double decor = moviebudget * 10 / 100;
        double costumesum = extras * priceofacostume;

        double total = costumesum + decor;

        if (extras > 150) {
            total = (costumesum - costumesum * 10 / 100) + decor;
        }

        if (total > moviebudget) {
            total = total - moviebudget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", total);
        } else if (moviebudget >= total) {
            total = moviebudget - total;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", total);
        }

    }
}
