package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = fillTheMatrix(scanner, rows, cols);

        for (int c = cols - 1; c > 0; c--) {
            for (int row = rows - 1, col = c; row >= 0 && col < cols; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        for (int r = rows - 1; r >= 0 ; r--) {
            for (int row = r, col = 0; row >= 0 && col < cols; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillTheMatrix(Scanner scanner, int rows, int cols) {
        int[][] array = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }
}
