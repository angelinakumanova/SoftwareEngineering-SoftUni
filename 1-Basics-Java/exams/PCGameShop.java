package exams;

import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldGames = Integer.parseInt(scanner.nextLine());
        double p1 = 0, p2 = 0, p3 = 0, p4 = 0;

        for (int i = soldGames; i > 0; i--) {
            String type = scanner.nextLine();
            if (type.equals("Hearthstone")) {
                p1++;
            } else if (type.equals("Fornite")) {
                p2++;
            } else if (type.equals("Overwatch")) {
                p3++;
            } else {
                p4++;
            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", p1 / soldGames * 100);
        System.out.printf("Fornite - %.2f%%%n", p2 / soldGames * 100);
        System.out.printf("Overwatch - %.2f%%%n", p3 / soldGames * 100);
        System.out.printf("Others - %.2f%%%n", p4 / soldGames * 100);
    }
}
