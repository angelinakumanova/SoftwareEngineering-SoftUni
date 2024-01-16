package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().split("[)(]")[1]);

        String input = scanner.nextLine();

        int longestLength = 0;
        List<String> words = new ArrayList<>();

        while (!"END".equals(input)) {
            words.add(input);
            if (input.length() > longestLength) {
                longestLength = input.length();
            }
            input = scanner.nextLine();
        }

        while (rotation > 360) {
                rotation -= 360;
        }

        if (rotation == 90) {
            char[][] rotatedMatrix = fillThe90Matrix(longestLength, words.size(), words);
            printMatrix(rotatedMatrix);
        } else if (rotation == 180) {
            char[][] rotatedMatrix = fillThe180Matrix(words.size(), longestLength, words);
            printMatrix(rotatedMatrix);
        } else if (rotation == 270) {
            char[][] rotatedMatrix = fillThe270Matrix(longestLength, words.size(), words);
            printMatrix(rotatedMatrix);
        } else {
            char[][] matrix = fillTheMatrix(words.size(), longestLength, words);
            printMatrix(matrix);
        }
    }


    private static void printMatrix (char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(row);
        }
    }

    private static char[][] fillTheMatrix (int rows, int cols, List<String> words) {
        char[][] matrix = new char[rows][cols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < words.get(row).length(); col++) {
                matrix[row][col] = words.get(row).charAt(col);
            }
        }

        return matrix;
    }
    private static char[][] fillThe90Matrix (int rows, int cols, List<String> words) {
        char[][] matrix = new char[rows][cols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }
        int index = words.size() - 1;
        for (int col = 0; col < cols; col++) {

            for (int row = 0; row < words.get(index).length(); row++) {
                matrix[row][col] = words.get(index).charAt(row);
            }
            index--;
        }

        return matrix;

    }

    private static char[][] fillThe180Matrix(int rows, int cols, List<String> words) {
        char[][] matrix = new char[rows][cols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        int idx = words.size() - 1;

        for (int row = 0; row < rows; row++) {
            int idxLetter = 0;
            for (int col = cols - 1; col >= (cols - 1) - (words.get(idx).length() - 1); col--) {
                matrix[row][col] = words.get(idx).charAt(idxLetter);
                idxLetter++;
            }
            idx--;
        }

        return matrix;
    }

    private static char[][] fillThe270Matrix(int rows, int cols, List<String> words) {
        char[][] matrix = new char[rows][cols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        for (int col = 0; col < cols; col++) {
            int idxLetter = 0;
            for (int row = rows - 1; row >= (rows - 1) - (words.get(col).length() - 1); row--) {
                matrix[row][col] = words.get(col).charAt(idxLetter);
                idxLetter++;
            }
        }

        return matrix;
    }
}
