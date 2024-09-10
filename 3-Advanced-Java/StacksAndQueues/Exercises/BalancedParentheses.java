package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if (!stack.isEmpty()) {
                if (bracket == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (bracket == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (bracket == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            } else {
                isBalanced = false;
                break;
            }
        }

        System.out.println(isBalanced && stack.isEmpty() ? "YES" : "NO");

    }
}

