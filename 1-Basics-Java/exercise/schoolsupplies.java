package exercise;

import java.util.Scanner;

public class schoolsupplies {
    public static void main(String[] args) {
        //Брой пакети химикали - цяло число в интервала [0...100]
        //
        //· Брой пакети маркери - цяло число в интервала [0...100]
        //
        //· Литри препарат за почистване на дъска - цяло число в интервала [0…50]
        //
        //· Процент намаление - цяло число в интервала [0...100]

        Scanner scanner = new Scanner(System.in);
        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int liters = Integer.parseInt(scanner.nextLine());
        int percentdiscount = Integer.parseInt(scanner.nextLine());

        double ppens = 5.80;
        double pmarkers = 7.20;
        double pperlitre = 1.20;

        double sum = (pens * ppens) + (markers * pmarkers) + (liters * pperlitre);
        double result = sum - (percentdiscount / 100.0 * sum);

        System.out.println(result);

    }
}
