package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        matrix = fillTheMatrix(rows, cols);

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            if (radius == 0 && areValidIndexes(row, col, matrix)) {
                matrix.get(row).remove(col);
            } else {
                for (int currRow = row - radius; currRow <= row + radius ; currRow++) {
                    if (areValidIndexes(currRow, col, matrix)) {
                        matrix.get(currRow).remove(col);
                    }
                }

                for (int currCol = col + radius; currCol >= col - radius; currCol--) {
                    if (areValidIndexes(row, currCol, matrix)) {
                        matrix.get(row).remove(currCol);
                    }

                }
            }


            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static List<List<Integer>> fillTheMatrix (int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int num = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(num);
                num++;
            }
        }

        return matrix;
    }

    private static boolean areValidIndexes(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row ) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
