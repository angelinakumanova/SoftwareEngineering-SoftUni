package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.Scanner;

public class IIIMidExam_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();
        int countTargets = 0;


        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (index < targets.length && index >= 0) {
                int currentTarget = targets[index];
                targets[index] = -1;
                countTargets++;

                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1) {
                        if (currentTarget < targets[i]) {
                            targets[i] -= currentTarget;
                        } else if (currentTarget >= targets[i]) {
                            targets[i] += currentTarget;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }


        System.out.printf("Shot targets: %d -> ", countTargets);
        for (int target : targets) {
            System.out.print(target + " ");
        }
    }
}
