package Arrays.MoreExercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[]{1, 1};
        int sum = 0;

        if (n == 0) {
            System.out.println("0");
        } else if (n == 1 || n == 2) {
            System.out.println("1");
        } else {
            for (int i = 2; i < n; i++) {
                sum = array[0] + array[1];
                array = new int[]{array[1],sum};
            }
            System.out.println(sum);
        }
    }
}
