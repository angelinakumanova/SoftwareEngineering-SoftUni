package exams;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sum = 0;
        String winnerName = "";
        int maxScore = 0;

        while (!"Stop".equals(input)) {

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                int number = Integer.parseInt(scanner.nextLine());
                if (number == symbol) {
                    sum += 10;
                } else {
                    sum += 2;
                }
                if (sum > maxScore) {
                    winnerName = input;
                    maxScore = sum;
                }
                if (sum == maxScore) {
                    winnerName = input;
                }

            } sum = 0;
            input = scanner.nextLine();

        }
        System.out.printf("The winner is %s with %d points!", winnerName, maxScore);
    }
}
