package AlgorithmsWorkShop;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(numbers, 0));
    }

    private static int sum(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        return nums[index] + sum(nums, index + 1);
    }

}
