package NestedLoopsLab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();

        while (!"End".equals(destination)) {
            double minimalBudget = Double.parseDouble(scanner.nextLine());
            while (minimalBudget > 0) {
                double money = Double.parseDouble(scanner.nextLine());
                minimalBudget -= money;
            }

            if (minimalBudget <= 0) {
                System.out.printf("Going to %s!%n", destination);
                destination = scanner.nextLine();
            }

        }

    }
}
