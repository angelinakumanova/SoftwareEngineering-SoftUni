package Methods.Exercises;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        getFactorialDivision(firstNumber, secondNumber);
    }

    public static void getFactorialDivision(int a, int b) {
        double firstFactorial = 1;
        double secondFactorial = 1;

        if (a != 0) {
            for (int i = 1; i <= a; i++) {
            firstFactorial *= i;
            }
        }
        if (b != 0) {
            for (int i = 1; i <= b; i++) {
                secondFactorial *= i;
            }
        }

        System.out.printf("%.2f", firstFactorial / secondFactorial);

    }
}
