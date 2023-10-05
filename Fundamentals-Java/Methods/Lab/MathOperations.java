package Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secondNumber = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##")
                .format(doCalculation(firstNumber, operator, secondNumber)));
    }

    public static double doCalculation (double firstNumber, String operator, double secondNumber) {
        if (operator.equals("+")) {
            return firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            return firstNumber - secondNumber;
        } else if (operator.equals("*")) {
            return firstNumber * secondNumber;
        }

        return firstNumber / secondNumber;
    }
}
