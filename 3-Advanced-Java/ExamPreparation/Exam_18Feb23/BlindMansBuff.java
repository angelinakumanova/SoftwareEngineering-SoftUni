package Exams.Exam_18Feb23;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    private static String[][] playground;
    private static int currentRowPos;
    private static int currentColPos;
    private static int countMoves = 0;
    private static int touchedPlayers = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        playground = fillThePlayground(scanner, rows, cols);


        String command = scanner.nextLine();
        while (!"Finish".equals(command) && touchedPlayers < 3) {
            playground[currentRowPos][currentColPos] = "-";
            switch (command) {
                case "up":
                    moveUp();
                    checkIfPlayer();
                    break;
                case "down":
                    moveDown();
                    checkIfPlayer();
                    break;
                case "left":
                    moveLeft();
                    checkIfPlayer();
                    break;
                case "right":
                    moveRight();
                    checkIfPlayer();
                    break;
            }
            playground[currentRowPos][currentColPos] = "B";
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedPlayers, countMoves);
    }

    private static String[][] fillThePlayground(Scanner scanner, int rows, int cols) {
        String[][] playground = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                playground[row][col] = tokens[col];
                if (tokens[col].equals("B")) {
                    currentRowPos = row;
                    currentColPos = col;
                }
            }
        }

        return playground;
    }
    private static void checkIfPlayer() {
        if (playground[currentRowPos][currentColPos].equals("P")) {
            touchedPlayers++;
        }
    }
    private static void moveUp() {
        if (currentRowPos - 1 >= 0 && !playground[currentRowPos - 1][currentColPos].equals("O")) {
            currentRowPos--;
            countMoves++;
        }
    }
    private static void moveDown() {
        if (currentRowPos + 1 < playground.length && !playground[currentRowPos + 1][currentColPos].equals("O")) {
            currentRowPos++;
            countMoves++;
        }
    }
    private static void moveLeft() {
        if (currentColPos - 1 >= 0 && !playground[currentRowPos][currentColPos - 1].equals("O")) {
            currentColPos--;
            countMoves++;
        }
    }
    private static void moveRight() {
        if (currentColPos + 1 < playground.length && !playground[currentRowPos][currentColPos + 1].equals("O")) {
            currentColPos++;
            countMoves++;
        }
    }

}
