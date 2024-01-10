package Methods.MoreExercises;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();
        String thirdNumber = scanner.nextLine();

        System.out.println(checkFinalProductSign(firstNumber, secondNumber, thirdNumber));
    }

    public static String checkFinalProductSign(String firstNumber, String secondNumber, String thirdNumber) {
        if (firstNumber.contains("-") || secondNumber.contains("-") || thirdNumber.contains("-")) {
            if (secondNumber.contains("-") && thirdNumber.contains("-")) {
                return "negative";
            } else if (secondNumber.contains("-") || thirdNumber.contains("-")) {
                return "positive";
            }
            return "negative";
        } else if (firstNumber.contains("0") || secondNumber.contains("0") || thirdNumber.contains("0")) {
            return "zero";
        }

        return "positive";
    }
}
