package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = fillTheArray(scanner, rows, cols);

        int maxSum = Integer.MIN_VALUE;
        int[][] resMatrix = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    resMatrix[0][0] = matrix[row][col];
                    resMatrix[0][1] = matrix[row][col + 1];
                    resMatrix[1][0] = matrix[row + 1][col];
                    resMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        printMatrix(resMatrix);
        System.out.println(maxSum);

    }

    private static int[][] fillTheArray (Scanner scanner, int rows, int cols) {
        int[][] array = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }

    private static void printMatrix (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
