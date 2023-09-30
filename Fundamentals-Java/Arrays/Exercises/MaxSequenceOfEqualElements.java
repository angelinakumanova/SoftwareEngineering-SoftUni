package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;


public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentSeqCount = 1;
        int longestSeqCount = 0;
        int longestSeqNumber = 0;
        int index = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                currentSeqCount++;
            } else {
                currentSeqCount = 1;
            }

            if (currentSeqCount > longestSeqCount) {
                longestSeqCount = currentSeqCount;
                longestSeqNumber = numbers[i];
            }
        }
        for (int i = 0; i < longestSeqCount; i++) {
            System.out.print(longestSeqNumber + " ");
        }

    }
}
