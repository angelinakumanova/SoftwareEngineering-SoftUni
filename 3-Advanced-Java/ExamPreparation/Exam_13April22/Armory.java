package ExamPreparation.Exam_13April22;

import java.util.Scanner;

public class Armory {
    private static String[][] matrix;
    private static int currentRowPos;
    private static int currentColPos;
    private static int[] firstMirrorDimensions = {-1, 0};
    private static int[] secondMirrorDimensions = new int[2];
    private static int goldCoins = 0;
    private static boolean isOutOfBoundaries = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        matrix = fillTheMatrix(scanner, size);

        while (goldCoins < 65) {
            String command = scanner.nextLine();

            matrix[currentRowPos][currentColPos] = "-";
            switch (command) {
                case "up":
                    currentRowPos--;
                    if (currentRowPos < 0) {
                        isOutOfBoundaries = true;
                        break;
                    }
                    checkPos();
                    break;
                case "down":
                    currentRowPos++;
                    if (currentRowPos >= matrix.length) {
                        isOutOfBoundaries = true;
                        break;
                    }
                    checkPos();
                    break;
                case "left":
                    currentColPos--;
                    if (currentColPos < 0) {
                        isOutOfBoundaries = true;
                        break;
                    }
                    checkPos();
                    break;
                case "right":
                    currentColPos++;
                    if (currentColPos >= matrix.length) {
                        isOutOfBoundaries = true;
                        break;
                    }
                    checkPos();
                    break;
            }

            if (isOutOfBoundaries) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.%n", goldCoins);
                printMatrix();
                return;
            }
            matrix[currentRowPos][currentColPos] = "A";
        }

        System.out.println("Very nice swords, I will come back for more!");
        System.out.printf("The king paid %d gold coins.%n", goldCoins);
        printMatrix();
    }

    private static String[][] fillTheMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                matrix[row][col] = input[col];
                if (matrix[row][col].equals("M")) {
                    if (firstMirrorDimensions[0] == -1) {
                        firstMirrorDimensions[0] = row;
                        firstMirrorDimensions[1] = col;
                    } else {
                        secondMirrorDimensions[0] = row;
                        secondMirrorDimensions[1] = col;
                    }
                } else if (matrix[row][col].equals("A")) {
                    currentRowPos = row;
                    currentColPos = col;
                }
            }

        }
        return matrix;
    }

    private static void checkPos() {
        if (matrix[currentRowPos][currentColPos].matches("\\d")) {
            goldCoins += Integer.parseInt(matrix[currentRowPos][currentColPos]);
        } else if (matrix[currentRowPos][currentColPos].equals("M")) {
            if (currentRowPos == firstMirrorDimensions[0]) {
                matrix[currentRowPos][currentColPos] = "-";
                currentRowPos = secondMirrorDimensions[0];
                currentColPos = secondMirrorDimensions[1];
            } else {
                matrix[currentRowPos][currentColPos] = "-";
                currentRowPos = firstMirrorDimensions[0];
                currentColPos = firstMirrorDimensions[1];
            }
        }
    }


    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
