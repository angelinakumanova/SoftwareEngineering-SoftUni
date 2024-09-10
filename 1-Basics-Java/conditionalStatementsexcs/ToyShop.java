package conditionalStatementsexcs;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        //2.Брой пъзели - цяло число в интервала [0… 1000]
        //3.Брой говорещи кукли - цяло число в интервала [0 … 1000]
        //4.Брой плюшени мечета - цяло число в интервала [0 … 1000]
        //5.Брой миньони - цяло число в интервала [0 … 1000]
        //6.Брой камиончета - цяло число в интервала [0 … 1000]

        Scanner scanner = new Scanner(System.in);
        double priceofvacay = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddybears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int lorries = Integer.parseInt(scanner.nextLine());

        double sum = (puzzles * 2.60) + (dolls * 3) + (teddybears * 4.10) + (minions * 8.20) + (lorries * 2);
        int amountoftoys = puzzles + dolls + teddybears + minions + lorries;

        if (amountoftoys >= 50) {
            sum = sum - sum * 25 / 100;
        }

        sum = sum - sum * 10 / 100;

        if (sum >= priceofvacay) {
            sum = sum - priceofvacay;
            System.out.printf("Yes! %.2f lv left.", sum);
        } else if (priceofvacay > sum) {
            sum = priceofvacay - sum;
            System.out.printf("Not enough money! %.2f lv needed.", sum);
        }
    }
}
