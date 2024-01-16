package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillTheMatrix(scanner, size);

        int primaryDiagonalSum = 0;
        for (int row = 0; row < size; row++) {
            primaryDiagonalSum += matrix[row][row];
        }

        int secondaryDiagonalSum = 0;
        int col = size - 1;
        for (int row = 0; row < size; row++) {
            secondaryDiagonalSum += matrix[row][col--];
        }

        System.out.println(Math.abs((primaryDiagonalSum - secondaryDiagonalSum)));
    }

    private static int[][] fillTheMatrix(Scanner scanner, int size) {
        int[][] array = new int[size][size];

        for (int row = 0; row < size; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }
}
