package Methods.Lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        doCalculation(command, firstNumber, secondNumber);
    }

    public static void doCalculation(String command, int firstNumber, int secondNumber) {
        if (command.equals("add")) {
            System.out.println(firstNumber + secondNumber);
        } else if (command.equals("multiply")) {
            System.out.println(firstNumber * secondNumber);
        } else if (command.equals("subtract")) {
            System.out.println(firstNumber - secondNumber);
        } else if (command.equals("divide")) {
            System.out.println(firstNumber / secondNumber);
        }
    }
}
