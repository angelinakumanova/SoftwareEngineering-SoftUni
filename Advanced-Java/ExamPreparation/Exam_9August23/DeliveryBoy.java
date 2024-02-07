package Exams.Exam_9August23;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    private static String[][] field;
    private static int currentRowPos;
    private static int currentColPos;
    private static boolean isOutOfBoundaries = false;
    private static boolean isDelivered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        field = fillTheField(scanner, rows, cols);

        int initialRow = currentRowPos;
        int initialCol = currentColPos;
        String command = scanner.nextLine();
        while (true) {


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

            if (!field[currentRowPos][currentColPos].equals("R") && !field[currentRowPos][currentColPos].equals("P")) {
                field[currentRowPos][currentColPos] = ".";
            }

            if (isOutOfBoundaries) {
                System.out.println("The delivery is late. Order is canceled.");
                field[initialRow][initialCol] = " ";
                printField();
                return;
            }
            if (isDelivered) {
                System.out.println("Pizza is delivered on time! Next order...");
                field[initialRow][initialCol] = "B";
                printField();
                return;
            }
            command = scanner.nextLine();
        }
    }


    private static void printField () {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }

    }

    private static void moveUp() {
        currentRowPos -= 1;

        if (currentRowPos < 0) {
            currentRowPos += 1;
            isOutOfBoundaries = true;
        } else if (field[currentRowPos][currentColPos].equals("*")) {
            currentRowPos += 1;
        }

    }

    private static void moveDown() {
        currentRowPos += 1;

        if (currentRowPos >= field.length) {
            currentRowPos -= 1;
            isOutOfBoundaries = true;
        } else if (field[currentRowPos][currentColPos].equals("*")) {
            currentRowPos -= 1;
        }
    }

    private static void moveLeft() {
        currentColPos -= 1;

        if (currentColPos < 0) {
            currentColPos += 1;
            isOutOfBoundaries = true;
        } else if (field[currentRowPos][currentColPos].equals("*")) {
            currentColPos += 1;
        }
    }

    private static void moveRight() {
        currentColPos += 1;

        if (currentColPos >= field[currentRowPos].length) {
            currentColPos -= 1;
            isOutOfBoundaries = true;
        } else if (field[currentRowPos][currentColPos].equals("*")) {
            currentColPos -= 1;
        }
    }

    private static void checkPos() {
        if (field[currentRowPos][currentColPos].equals("P")) {
            field[currentRowPos][currentColPos] = "R";
            System.out.println("Pizza is collected. 10 minutes for delivery.");
        } else if (field[currentRowPos][currentColPos].equals("A")) {
            field[currentRowPos][currentColPos] = "P";
            isDelivered = true;
        }
    }

    private static String[][] fillTheField(Scanner scanner, int rows, int cols) {
        String[][] field = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("");
            for (int i = 0; i < tokens.length; i++) {
                field[row][i] = tokens[i];
                if (tokens[i].equals("B")) {
                    currentRowPos = row;
                    currentColPos = i;
                }
            }
        }

        return field;
    }
}
