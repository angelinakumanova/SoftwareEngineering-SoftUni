package ForLoopsExercises;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 200) {
                p1 += 1;
            } else if (number <= 399) {
                p2 += 1;
            } else if (number <= 599) {
                p3 += 1;
            } else if (number <= 799) {
                p4 += 1;
            } else  {
                p5 += 1;
            }
        }
        System.out.printf("%.2f%%%n", p1 = 100 * p1 / n);
        System.out.printf("%.2f%%%n", p2 = 100 * p2 / n);
        System.out.printf("%.2f%%%n", p3 = 100 * p3 / n);
        System.out.printf("%.2f%%%n", p4 = 100 * p4 / n);
        System.out.printf("%.2f%%%n", p5 = 100 * p5 / n);
    }

}
