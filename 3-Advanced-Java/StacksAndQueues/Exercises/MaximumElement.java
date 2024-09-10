package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            int[] commandTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            if (commandTokens[0] == 1) {
                stack.push(commandTokens[1]);
            } else if (commandTokens[0] == 2) {
                stack.pop();
            } else if (commandTokens[0] == 3) {
                System.out.println(getMaxElement(stack));
            }
        }
    }

    private static int getMaxElement(ArrayDeque<Integer> stack) {
        int maxElement = Integer.MIN_VALUE;
        Integer[] stackArr = stack.toArray(new Integer[0]);
        for (Integer num : stackArr) {
            if (num > maxElement) {
                maxElement = num;
            }
        }
        return maxElement;
    }
}
