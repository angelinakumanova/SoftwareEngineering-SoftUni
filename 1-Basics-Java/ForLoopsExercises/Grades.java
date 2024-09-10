package ForLoopsExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        double p1 = 0, p2 = 0, p3 = 0, p4 = 0;
        double totalGrades = 0;

        for (int i = 1; i <= students ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            totalGrades += grade;
            if (grade >= 2.00 & grade <= 2.99) {
                p1++;
            } else if (grade <= 3.99) {
                p2++;
            } else if (grade <= 4.99) {
                p3++;
            } else {
                p4++;
            }

        }
        System.out.printf("Top students: %.2f%%%n", p4 / students * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", p3 / students * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", p2 / students * 100);
        System.out.printf("Fail: %.2f%%%n", p1 / students * 100);
        System.out.printf("Average: %.2f", totalGrades / students);
    }
}
