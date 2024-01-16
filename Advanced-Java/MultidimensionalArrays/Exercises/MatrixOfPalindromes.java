package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

    private static final char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = fillTheMatrix(rows, cols);
        printTheMatrix(matrix);
    }

    private static String[][] fillTheMatrix (int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Character.toString(letters[row]) + letters[row + col] + letters[row];
            }
        }

        return matrix;
    }

    private static void printTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[,\\]]", ""));
        }
    }
}
