package Exams.Exam_12April23;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TheSquirrel {
    private static String[][] field;
    private static int currentRowPos;
    private static int currentColPos;
    private static boolean isOutOfBoundaries = false;
    private static boolean isTrapped = false;
    private static int hazelnuts = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",\\s+");
        field = fillTheField(scanner, size);
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            field[currentRowPos][currentColPos] = "*";

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

            if (isTrapped) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                return;
            } else if (isOutOfBoundaries) {
                System.out.println("The squirrel is out of the field.");
                System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
                return;
            }
            field[currentRowPos][currentColPos] = "s";
        }

        System.out.println(hazelnuts == 3 ? "Good job! You have collected all hazelnuts!"
                : "There are more hazelnuts to collect.");
        System.out.printf("Hazelnuts collected: %d", hazelnuts);
    }

    private static String[][] fillTheField(Scanner scanner, int size) {
        String[][] field = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] tokens = scanner.nextLine().split("");
            for (int i = 0; i < tokens.length; i++) {
                field[row][i] = tokens[i];
                if (tokens[i].equals("s")) {
                    currentRowPos = row;
                    currentColPos = i;
                }
            }
        }

        return field;
    }

    private static void moveUp() {
        currentRowPos -= 1;

        if (currentRowPos < 0) {
            currentRowPos += 1;
            isOutOfBoundaries = true;
        }

    }

    private static void moveDown() {
        currentRowPos += 1;

        if (currentRowPos >= field.length) {
            currentRowPos -= 1;
            isOutOfBoundaries = true;
        }
    }

    private static void moveLeft() {
        currentColPos -= 1;

        if (currentColPos < 0) {
            currentColPos += 1;
            isOutOfBoundaries = true;
        }
    }

    private static void moveRight() {
        currentColPos += 1;

        if (currentColPos >= field[currentRowPos].length) {
            currentColPos -= 1;
            isOutOfBoundaries = true;
        }
    }


    private static void checkPos() {
        if (field[currentRowPos][currentColPos].equals("h")) {
            hazelnuts++;
        } else if (field[currentRowPos][currentColPos].equals("t")) {
            isTrapped = true;
        }
    }
}
