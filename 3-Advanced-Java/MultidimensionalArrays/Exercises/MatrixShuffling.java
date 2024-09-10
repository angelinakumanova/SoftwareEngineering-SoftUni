package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = fillTheMatrix(scanner, rows, cols);

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] inputTokens = input.split("\\s+");

            if ("swap".equals(inputTokens[0]) && inputTokens.length < 6) {
                int firstRow = Integer.parseInt(inputTokens[1]);
                int firstCol = Integer.parseInt(inputTokens[2]);
                int secondRow = Integer.parseInt(inputTokens[3]);
                int secondCol = Integer.parseInt(inputTokens[4]);

                if (firstRow < rows && firstCol < cols && secondRow < rows && secondCol < cols) {
                    String firstElement = matrix[firstRow][firstCol];
                    String secondElement = matrix[secondRow][secondCol];

                    matrix[firstRow][firstCol] = secondElement;
                    matrix[secondRow][secondCol] = firstElement;

                    printTheMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    private static String[][] fillTheMatrix (Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }

    private static void printTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[,\\]]", ""));
        }
    }
}
