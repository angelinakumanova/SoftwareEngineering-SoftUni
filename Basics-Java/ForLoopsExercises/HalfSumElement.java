package ForLoopsExercises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int maxNumber = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > maxNumber) {
                maxNumber = number;
            }
            result += number ;
        }
        result -= maxNumber;

        if (result == maxNumber) {
            System.out.println("Yes");
            System.out.println("Sum = " + result);
        } else {
            System.out.println("No");
            System.out.println("Diff = " + Math.abs(result - maxNumber));
        }
    }
}
