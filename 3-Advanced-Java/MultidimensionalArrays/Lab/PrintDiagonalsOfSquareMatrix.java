package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillTheArray(scanner, size);

        int[][] result = new int[2][size];
        int topLeft = 0;
        int bottomLeft = size - 1;
        int col = 0;

        for (int i = 0; i < size; i++) {
            result[0][col] = matrix[topLeft][col];
            result[1][col] = matrix[bottomLeft][col];
            col++;
            topLeft++;
            bottomLeft--;

        }

        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static int[][] fillTheArray (Scanner scanner, int size) {
        int[][] array = new int[size][size];

        for (int row = 0; row < size; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }
}
