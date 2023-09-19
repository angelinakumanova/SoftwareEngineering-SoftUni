package whileLoopsExercises;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double sum = 0;

        for (int i = n; i > 0 ; i--) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        System.out.printf("%.2f", sum / n);
    }
}
