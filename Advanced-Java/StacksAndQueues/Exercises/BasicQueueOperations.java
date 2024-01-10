package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split("\\s+");
        int elementsToEnqueue = Integer.parseInt(inputTokens[0]);
        int elementsToDequeue = Integer.parseInt(inputTokens[1]);
        int elementToCheck = Integer.parseInt(inputTokens[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>(elementsToEnqueue);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 0; i < elementsToDequeue; i++) {
            queue.poll();
        }

        if (queue.contains(elementToCheck)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(smallestNumInQueue(queue));
        }
    }


    private static int smallestNumInQueue(ArrayDeque<Integer> queue) {
        int smallestNum = Integer.MAX_VALUE;
        Integer[] queueArr = queue.toArray(new Integer[0]);
        for (Integer num : queueArr) {
            if (num < smallestNum) {
                smallestNum = num;
            }
        }

        return smallestNum;
    }
}
