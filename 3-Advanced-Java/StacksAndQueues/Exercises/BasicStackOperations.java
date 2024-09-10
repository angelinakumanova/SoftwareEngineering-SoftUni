package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split("\\s+");
        int elementsToPush = Integer.parseInt(inputTokens[0]);
        int elementsToPop = Integer.parseInt(inputTokens[1]);
        int elementToCheck = Integer.parseInt(inputTokens[2]);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(nums[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        Integer[] stackAsArr = stack.toArray(new Integer[0]);
        int smallestNum = Integer.MAX_VALUE;
        for (Integer num : stackAsArr) {
            if (num < smallestNum) {
                smallestNum = num;
            }
        }

        if (stack.contains(elementToCheck)) {
            System.out.println("true");
        } else if (stack.isEmpty()){
            System.out.println("0");
        } else {
            System.out.println(smallestNum);
        }
    }
}
