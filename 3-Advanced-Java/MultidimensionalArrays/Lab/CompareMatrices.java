package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstRows = firstDimensions[0];
        int firstCols = firstDimensions[1];

        int[][] firstArr = new int[firstRows][firstCols];
        firstArr = fillTheArray(scanner, firstRows, firstCols);

        int[] secondDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondRows = secondDimensions[0];
        int secondCols = secondDimensions[1];

        int[][] secondArr = new int[secondRows][secondCols];
        secondArr = fillTheArray(scanner, firstRows, firstCols);

        if (!areEquals(firstDimensions, secondDimensions)) {
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < firstRows; i++) {
            if (!areEquals(firstArr[i], secondArr[i])) {
                System.out.println("not equal");
                return;
            }
        }

        System.out.println("equal");
    }

    private static int[][] fillTheArray (Scanner scanner, int rows, int cols) {
        int[][] array = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return array;
    }

    private static boolean areEquals (int[] firstArr, int[] secondArr) {
        if (firstArr.length != secondArr.length) return false;

        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] != secondArr[i]) {
                return false;
            }
        }

        return true;
    }

}
