package whileLoopsExercises;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int possibleBadGrades = Integer.parseInt(scanner.nextLine());
        int badGradesCount = 0;
        int tasksCounter = 0;
        double sumGrades = 0.0;
        String lastProblem = "";

        while (badGradesCount < possibleBadGrades) {
            String task = scanner.nextLine();
            if ("Enough".equals(task)) {
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            tasksCounter++;
            sumGrades += grade;
            if (grade <= 4) {
                badGradesCount++;
            }
            lastProblem = task;
        }
        if (badGradesCount >= possibleBadGrades) {
            System.out.printf("You need a break, %d poor grades.", badGradesCount);
        } else {
            System.out.printf("Average score: %.2f%n", (sumGrades / tasksCounter));
            System.out.printf("Number of problems: %d%n", tasksCounter);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
