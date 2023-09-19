package NestedLoopsExercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfJudges = Integer.parseInt(scanner.nextLine());

        double grades = 0.0;
        int presentationsCount = 0;

        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            ++presentationsCount;
            String presentationName = input;

            double presentationGrades = 0.0;
            for (int i = 0; i < numOfJudges; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                presentationGrades += grade;
            }

            grades += presentationGrades;
            double presentationAvrGrade = presentationGrades / numOfJudges;
            System.out.printf("%s - %.2f.%n", presentationName, presentationAvrGrade);

            input = scanner.nextLine();
        }

        double result = grades / (presentationsCount * numOfJudges);
        System.out.printf("Student's final assessment is %.2f.", result);
    }
}
