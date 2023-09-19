package exams;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();

        double sum = dancers * points;
        if ("Abroad".equals(place)) {
            sum += sum * 50 / 100;
            if ("summer".equals(season)) {
                sum -= sum * 0.10;
            } else if ("winter".equals(season)) {
                sum -= sum * 0.15;
            }
        } else if ("Bulgaria".equals(place)) {
            if ("summer".equals(season)) {
                sum -= sum * 0.05;
            } else if ("winter".equals(season)) {
                sum -= sum * 0.08;
            }
        }

        double moneyForCharity = sum * 0.75;
        double leftMoney = (sum - moneyForCharity) / dancers;

        System.out.printf("Charity - %.2f%n", moneyForCharity);
        System.out.printf("Money per dancer - %.2f", leftMoney);

    }
}
