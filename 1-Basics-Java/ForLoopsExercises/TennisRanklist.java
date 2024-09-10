package ForLoopsExercises;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tournaments = Integer.parseInt(scanner.nextLine());
        int startPoints = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        double wonTournaments = 0.0;

        for (int i = 0; i < tournaments; i++) {
            String phase = scanner.nextLine();
            if (phase.equals("W")) {
                sum += 2000;
            } else if (phase.equals("F")) {
                sum += 1200;
            } else if (phase.equals("SF")) {
                sum += 720;
            }
            if (phase.equals("W")) {
                ++wonTournaments;
            }
        }
        System.out.printf("Final points: %d%n", sum + startPoints);
        sum = sum / tournaments;
        sum = (int) Math.floor(sum);
        System.out.printf("Average points: %d%n", sum);
        System.out.printf("%.2f%%", (wonTournaments / tournaments) * 100);
    }
}
