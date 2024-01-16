package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimAndPattern = scanner.nextLine().split(", ");
        int size = Integer.parseInt(dimAndPattern[0]);
        String pattern = dimAndPattern[1];

        if (pattern.equals("A")) {
            int[][] matrix = fillTheMatrixA(size);
            printTheMatrix(matrix);
        } else if (pattern.equals("B")) {
            int[][] matrix = fillTheMatrixB(size);
            printTheMatrix(matrix);
        }
    }

    private static int[][] fillTheMatrixA (int size) {
        int[][] matrix = new int[size][size];

        int initialNum = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = initialNum++;
            }
        }

        return matrix;
    }

    private static int[][] fillTheMatrixB (int size) {
        int[][] matrix = new int[size][size];

        int initialNum = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = initialNum++;
                }
            } else {
                for (int row = size - 1; row >= 0 ; row--) {
                    matrix[row][col] = initialNum++;
                }
            }
        }
        return matrix;
    }

    private static void printTheMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
