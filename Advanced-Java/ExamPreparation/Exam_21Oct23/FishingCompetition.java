package Exams.Exam_21Oct23;

import java.util.Arrays;
import java.util.Scanner;

public class FishingCompetition {

    private static String[][] matrix;
    private static int currentRowPos;
    private static int currentColPos;
    private static int collectedTonsOfFish = 0;
    private static boolean isInWhirpool = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        matrix = fillTheMatrix(scanner, n);
        int[] pos = findInitialPos(matrix);
        currentRowPos = pos[0];
        currentColPos = pos[1];

        String command = scanner.nextLine();
        while (!"collect the nets".equals(command)) {
            matrix[currentRowPos][currentColPos] = "-";
            switch (command) {
                case "up":
                    moveUp();
                    checkPos();
                    break;
                case "down":
                    moveDown();
                    checkPos();
                    break;
                case "left":
                    moveLeft();
                    checkPos();
                    break;
                case "right":
                    moveRight();
                    checkPos();
                    break;
            }

            matrix[currentRowPos][currentColPos] = "S";
            if (isInWhirpool) {
                return;
            }
            command = scanner.nextLine();
        }


        System.out.printf(collectedTonsOfFish >= 20 ? "Success! You managed to reach the quota!%n" :
                            "You didn't catch enough fish and didn't reach the quota!" +
                                    " You need %d tons of fish more.\n",
                20 - collectedTonsOfFish);

        if (collectedTonsOfFish > 0) System.out.printf("Amount of fish caught: %d tons.%n", collectedTonsOfFish);

        printMatrix();

    }

    private static void moveUp() {
        currentRowPos -= 1;
        if (currentRowPos < 0) {
            currentRowPos = matrix.length - 1;
        }
    }

    private static void moveDown() {
        currentRowPos += 1;
        if (currentRowPos >= matrix.length) {
            currentRowPos = 0;
        }
    }

    private static void moveLeft() {
        currentColPos -= 1;
        if (currentColPos < 0) {
            currentColPos = matrix.length - 1;
        }
    }

    private static void moveRight() {
        currentColPos += 1;
        if (currentColPos >= matrix.length) {
            currentColPos = 0;
        }
    }

    private static void checkPos() {

        if (matrix[currentRowPos][currentColPos].matches("\\d")) {
            collectedTonsOfFish += Integer.parseInt(matrix[currentRowPos][currentColPos]);
            matrix[currentRowPos][currentColPos] = "-";
        } else if (matrix[currentRowPos][currentColPos].equals("W")) {
            System.out.printf("You fell into a whirlpool!" +
                    " The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]",
                    currentRowPos, currentColPos);
            isInWhirpool = true;
        }
    }

    private static String[][] fillTheMatrix(Scanner scanner, int size) {
        String[][] array = new String[size][size];

        for (int row = 0; row < size; row++) {
            array[row] = scanner.nextLine().split("");
        }
        return array;
    }

    private static void printMatrix () {
        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[]\\[,\\s]", ""));
        }
    }

    private static int[] findInitialPos (String[][] matrix) {
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }

        return pos;
    }
}
