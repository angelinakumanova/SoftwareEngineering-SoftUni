package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Zig_ZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int [] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
          int [] array = Arrays.stream(scanner.nextLine().split(" "))
                  .mapToInt(value -> Integer.parseInt(value))
                  .toArray();
          if (i % 2 == 0) {
              firstArray[i] = array[0];
              secondArray[i] = array[1];
          } else {
              firstArray[i] = array[1];
              secondArray[i] = array[0];
          }
        }

        for (int number : firstArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondArray) {
            System.out.print(number + " ");
        }

    }
}
