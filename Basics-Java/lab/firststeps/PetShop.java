package lab.firststeps;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dogsfood = 2.50;
        int catsfood = 4;
        int amountdogs = Integer.parseInt(scanner.nextLine());
        int amountcats = Integer.parseInt(scanner.nextLine());

        double dogcalc = 2.50 * amountdogs;
        int catcalc = 4 * amountcats;

        double sum = dogcalc + catcalc;

        String result = "%f lv.";

        System.out.printf(result, sum);

    }
}
