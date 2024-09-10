package whileLoopsExercises;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goal = 10000;

        while (goal > 0) {
            String input = scanner.nextLine();
            if ("Going home".equals(input)) {
                int finalSteps = Integer.parseInt(scanner.nextLine());
                goal -= finalSteps;
                break;
            }
            int steps = Integer.parseInt(input);
            goal -= steps;
        }
        if (goal <= 0) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", Math.abs(goal));
        }
        if (goal > 0) {
            System.out.printf("%d more steps to reach goal.", goal);
        }
    }
}
