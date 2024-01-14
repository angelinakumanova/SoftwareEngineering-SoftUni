package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = fillTheArray(scanner, rows, cols);
        char[][] secondMatrix = fillTheArray(scanner, rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }

    private static char[][] fillTheArray (Scanner scanner, int rows, int cols) {
        char[][] array = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
           array[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        return array;
    }
}
