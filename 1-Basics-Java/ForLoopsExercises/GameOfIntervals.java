package ForLoopsExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int games = Integer.parseInt(scanner.nextLine());
        double points = 0;
        double totalSum = 0;
        double p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0;


        for (int i = 1; i <= games ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 0 && number <= 9) {
                points = number * 20 / 100.0;
                totalSum += points;
                p1++;
            } else if (number >= 10 && number <= 19) {
                points = number * 30 / 100.0;
                totalSum += points;
                p2++;
            } else if (number >= 20 && number <= 29) {
                points = number * 40 / 100.0;
                totalSum += points;
                p3++;
            } else if (number >= 30 && number <= 39) {
                points = 50;
                totalSum += points;
                p4++;
            } else if (number >= 40 && number <= 50) {
                points = 100;
                totalSum += points;
                p5++;
            } else {
                totalSum /= 2;
                p6++;
            }
        }
        System.out.printf("%.2f%n", totalSum);
        System.out.printf("From 0 to 9: %.2f%%%n", p1 / games * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", p2 / games * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", p3 / games * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", p4 / games * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", p5 / games * 100);
        System.out.printf("Invalid numbers: %.2f%%%n", p6 / games * 100);

    }
}
