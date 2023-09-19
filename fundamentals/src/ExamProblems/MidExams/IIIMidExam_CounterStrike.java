package ExamProblems.MidExams;

import java.util.Scanner;

public class IIIMidExam_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int wonBattles = 0;

        while (!input.equals("End of battle")) {
            int distanceOfEnemy = Integer.parseInt(input);
            if (initialEnergy >= distanceOfEnemy) {
                initialEnergy -= distanceOfEnemy;
                wonBattles++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                        wonBattles, initialEnergy);
                return;
            }
            if (wonBattles % 3 == 0) {
                initialEnergy += wonBattles;
            }

            input = scanner.nextLine();

        }   System.out.printf("Won battles: %d. Energy left: %d", wonBattles, initialEnergy);


    }
}
