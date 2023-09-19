package conditionalStatementsexcs;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        //1.Бюджетът на Петър - реално число в интервала [0.0…100000.0]
        //2.Броят видеокарти - цяло число в интервала [0…100]
        //3.Броят процесори - цяло число в интервала [0…100]
        //4.Броят рам памет - цяло число в интервала [0…100]


        Scanner scanner = new Scanner(System.in);
        double budgetofPetur = Double.parseDouble(scanner.nextLine());
        int videocards = Integer.parseInt(scanner.nextLine());
        int cpus = Integer.parseInt(scanner.nextLine());
        int rammemory = Integer.parseInt(scanner.nextLine());

        int videocardsprice = 250 * videocards;
        double cpuprice = cpus * (videocardsprice * 35 / 100.0);
        double rammemprice = rammemory * (videocardsprice * 10 / 100.0);

        double total = videocardsprice + cpuprice + rammemprice;

        if (videocards > cpus) {
            total = total - total * 15 / 100;
        }

        if (budgetofPetur >= total) {
            total = budgetofPetur - total;
            System.out.printf("You have %.2f leva left!", total);
        } else if (total > budgetofPetur) {
            total = total - budgetofPetur;
            System.out.printf("Not enough money! You need %.2f leva more!", total);

        }
    }
}
