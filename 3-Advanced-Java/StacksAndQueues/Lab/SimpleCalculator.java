package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] tokens = input.split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            stack.push(token);
        }

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operand.equals("+")) {
                stack.push(String.valueOf(firstNum + secondNum));
            } else if (operand.equals("-")) {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }

        System.out.println(stack.pop());
    }
}
