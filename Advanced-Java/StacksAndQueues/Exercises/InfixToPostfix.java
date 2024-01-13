package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression = scanner.nextLine().split(" ");
        printExpression(infixToPostfix(expression));

    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private static Deque<String> infixToPostfix(String[] expression) {
        Deque<String> operatorStack = new ArrayDeque<>();
        Deque<String> outputQueue = new ArrayDeque<>();

        for (String symbol : expression) {
            char token = symbol.charAt(0);
            if (Character.isDigit(token) || Character.isLetter(token)) {
                outputQueue.offer(symbol);
            } else if (token == '(') {
                operatorStack.push(symbol);
            } else if (token == ')') {
                while (!operatorStack.isEmpty() && !(operatorStack.peek().equals("("))) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && precedence(symbol) <= precedence(operatorStack.peek())) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.push(symbol);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        return outputQueue;
    }

    private static void printExpression (Deque<String> outputQueue) {
        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }
    }
}
