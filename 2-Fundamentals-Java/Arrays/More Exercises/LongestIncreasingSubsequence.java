package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;


public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxLength = 0;
        int lastIndex = -1;

        int[] len = new int[numbers.length];
        int[] prev = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            len[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1)  {
            lis[currentIndex] = numbers[lastIndex];
            currentIndex--;
            lastIndex = prev[lastIndex];
        }
        for (int number : lis) {
            System.out.print(number + " ");
        }
    }
}
