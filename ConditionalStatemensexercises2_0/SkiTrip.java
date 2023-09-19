package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String grade = scanner.nextLine();

        double price = 0.0;

        if (type.equals("room for one person")) {
            price = days * 18.00 - 18.00;
        } else if (type.equals("apartment")) {
            price = days * 25.00 - 25.00;
            if (days < 10) {
                price *= 0.7;
            } else if (days > 15) {
                price *= 0.5;
            } else {
                price *= 0.65;
            }
        } else if (type.equals("president apartment")) {
            price = days * 35.00 - 35.00;
            if (days < 10) {
                price *= 0.9;
            } else if (days > 15) {
                price *= 0.8;
            } else {
                price *= 0.85;
            }
        }
        if (grade.equals("positive")) {
            price *= 1.25;
        } else if (grade.equals("negative")) {
            price *= 0.9;
        }
        System.out.printf("%.2f", price);
    }
}
