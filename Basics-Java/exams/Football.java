package exams;

import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String bestPlayer = "";
        int mostGoals = 0;

        while (!"END".equals(input)) {
            int goals = Integer.parseInt(scanner.nextLine());
            if (goals >= 10) {
                bestPlayer = input;
                mostGoals = goals;
                break;
            }
            if (goals > mostGoals) {
                bestPlayer = input;
                mostGoals = goals;
            }
            input = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", bestPlayer);
        if (mostGoals >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", mostGoals);
        } else {
            System.out.printf("He has scored %d goals.", mostGoals);
        }

    }
}
