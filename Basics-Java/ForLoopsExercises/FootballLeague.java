package ForLoopsExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacityOfStadium = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());
        double p1 = 0, p2 = 0, p3 = 0, p4 = 0;

        for (int i = 1; i <= fans ; i++) {
            char sector = scanner.next().charAt(0);
            switch (sector) {
                case 'A':
                    p1++;
                    break;
                case 'B':
                    p2++;
                    break;
                case 'V':
                    p3++;
                    break;
                case 'G':
                    p4++;
                    break;
            }

        }
        System.out.printf("%.2f%%%n", p1 / fans * 100);
        System.out.printf("%.2f%%%n", p2 / fans * 100);
        System.out.printf("%.2f%%%n", p3 / fans * 100);
        System.out.printf("%.2f%%%n", p4 / fans * 100);
        System.out.printf("%.2f%%", (double)fans / capacityOfStadium * 100);
    }
}
