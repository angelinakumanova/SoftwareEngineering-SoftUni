package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        if (num == 0) {
            System.out.println("0");
            return;
        }

        ArrayDeque<String> stack = new ArrayDeque<>();
        while (num != 0) {
            stack.push(String.valueOf(num % 2));
            num /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
