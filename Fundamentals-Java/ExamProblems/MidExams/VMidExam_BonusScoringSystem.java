package ExamProblems.MidExams;

import java.util.Scanner;

public class VMidExam_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int totalLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double sumBonus = 0;
        double maxBonus = 0;
        int attendedLectures = 0;

        for (int i = 1; i <= numberOfStudents ; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            sumBonus = ((double) attendance / totalLectures) * (5 + additionalBonus);
            if (sumBonus > maxBonus) {
                maxBonus = sumBonus;
                attendedLectures = attendance;
            }


        }
        System.out.printf("Max Bonus: %d.%n", Math.round(maxBonus));
        System.out.printf("The student has attended %d lectures.", attendedLectures);

    }
}
