package ExamProblems.MidExams;

import java.util.Scanner;

public class VIMidExam_BlackFlag {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int daysPirating = Integer.parseInt(scanner.nextLine());
    int dailyPlunder = Integer.parseInt(scanner.nextLine());
    double expectedTarget = Double.parseDouble(scanner.nextLine());

    double gatheredPlunder = 0;

        for (int i = 1; i <= daysPirating ; i++) {
            gatheredPlunder += dailyPlunder;
            if (i % 3 == 0) {
                gatheredPlunder += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                gatheredPlunder = gatheredPlunder - (gatheredPlunder * 0.3);
            }
        }
        if (gatheredPlunder >= expectedTarget) {
            System.out.printf("Ahoy! %.2f plunder gained.", gatheredPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (gatheredPlunder / expectedTarget) * 100);
        }
    }
}
