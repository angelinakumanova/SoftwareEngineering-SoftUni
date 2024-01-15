package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillTheMatrix(scanner, rows);

        int[] wrongValueDims = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int wrongValue = matrix[wrongValueDims[0]][wrongValueDims[1]];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    matrix[row][col] = calculateSumOfNewValue(matrix, row, col, wrongValue);
                }
            }
        }

        printMatrix(matrix);
    }

    private static int[][] fillTheMatrix (Scanner scanner, int rows) {
        int[][] array = new int[rows][];

        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }
    
    private static int calculateSumOfNewValue (int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;
        // Left move
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }

        // Right move
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }

        // Up move
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }

        // Down move
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }

        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
