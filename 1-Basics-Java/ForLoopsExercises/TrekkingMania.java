package ForLoopsExercises;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        double sum = 0.0;

        int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0;

        for (int i = 0; i < groups; i++) {
            int peoplePerGroup = Integer.parseInt(scanner.nextLine());
            sum += peoplePerGroup;

            if (peoplePerGroup <= 5) {
                p1 += peoplePerGroup;
            } else if (peoplePerGroup <= 12) {
                p2 += peoplePerGroup;
            } else if (peoplePerGroup <= 25) {
                p3 += peoplePerGroup;
            } else if (peoplePerGroup <= 40) {
                p4 += peoplePerGroup;
            } else  {
                p5 += peoplePerGroup;
            }
        }
        System.out.printf("%.2f%%%n", p1 / sum * 100);
        System.out.printf("%.2f%%%n", p2 / sum * 100);
        System.out.printf("%.2f%%%n", p3 / sum * 100);
        System.out.printf("%.2f%%%n", p4 / sum * 100);
        System.out.printf("%.2f%%%n", p5 / sum * 100);
    }
}
