package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] array = fillTheArray(scanner, rows, cols);

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += array[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }

    private static int[][] fillTheArray (Scanner scanner, int rows, int cols) {
        int[][] array = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }
}
