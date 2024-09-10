package WorkingWithAbstraction.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class JediGalaxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!"Let the Force be with you".equals(command)) {
            int[] playerCoords = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoords = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            evilDestroys(evilCoords, matrix);
            sum = playerCollectsStars(playerCoords, sum, matrix);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static int[][] fillMatrix(int rows, int cols, int[][] matrix) {
        int starValue = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = starValue++;
            }
        }

        return matrix;
    }

    private static void evilDestroys(int[] evilCoords, int[][] matrix) {
        int evilRow = evilCoords[0];
        int evilCol = evilCoords[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long playerCollectsStars(int[] playerCoords, long sum, int[][] matrix) {
        int playerRow = playerCoords[0];
        int playerCol = playerCoords[1];

        while (playerRow >= 0 && playerCol < matrix[0].length) {
            if (playerRow < matrix.length && playerCol >= 0) {
                sum += matrix[playerRow][playerCol];
            }

            playerCol++;
            playerRow--;
        }

        return sum;
    }
}
