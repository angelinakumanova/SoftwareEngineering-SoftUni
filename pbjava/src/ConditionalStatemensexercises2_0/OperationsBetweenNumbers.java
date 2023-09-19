package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        char operation = scanner.nextLine().charAt(0);


        int result = 0;

        if (y == 0) {
            System.out.printf("Cannot divide %d by zero", x);
        } else {

            switch (operation) {
                case '+':
                    result = x + y;
                    if (result % 2 == 0) {
                        System.out.printf("%d %c %d = %d - even", x, operation, y, result);
                    } else {
                        System.out.printf("%d %c %d = %d - odd", x, operation, y, result);
                    }
                    break;
                case '-':
                    result = x - y;
                    if (result % 2 == 0) {
                        System.out.printf("%d %c %d = %d - even", x, operation, y, result);
                    } else {
                        System.out.printf("%d %c %d = %d - odd", x, operation, y, result);
                    }
                    break;
                case '*':
                    result = x * y;
                    if (result % 2 == 0) {
                        System.out.printf("%d %c %d = %d - even", x, operation, y, result);
                    } else {
                        System.out.printf("%d %c %d = %d - odd", x, operation, y, result);
                    }
                    break;
                case '/':
                    double divresult = (double) x / y;
                    System.out.printf("%d / %d = %.2f", x, y, divresult);
                    break;
                case '%':
                    result = x % y;
                    System.out.printf("%d %c %d = %d", x, operation, y, result);
                    break;
            }
        }
    }
}
