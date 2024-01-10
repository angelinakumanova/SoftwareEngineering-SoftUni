package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);

        for (int i = 2; i <= n; i++) {
            long second = stack.pop();
            long first = stack.pop();
            long currentFibonacci = first + second;

            stack.push(second);
            stack.push(currentFibonacci);
        }

        System.out.println(stack.peek());
        
    }
}
