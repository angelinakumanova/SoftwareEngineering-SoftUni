package ExamProblems;

import java.util.Scanner;

public class IIMidExam_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeTime = Integer.parseInt(scanner.nextLine());
        int secondEmployeeTime = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeTime = Integer.parseInt(scanner.nextLine());
        int amountOfStudents = Integer.parseInt(scanner.nextLine());


        int totalStudentsPerHour = (firstEmployeeTime + secondEmployeeTime + thirdEmployeeTime);
        int countHours = 0;

        while (amountOfStudents > 0) {
            countHours++;
            if (countHours % 4 == 0) {
                continue;
            }
            amountOfStudents -= totalStudentsPerHour;

        }
        System.out.printf("Time needed: %dh.", countHours);
    }
}
