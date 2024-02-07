package Exams.Exam_17June23;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    private static String[][] cupboardArea;
    private static int currentRowPos;
    private static int currentColPos;
    private static int cheeseCount = 0;
    private static boolean isOutOfBoundaries = false;
    private static boolean isTrapped = false;
    private static boolean allCheeseIsFound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        cupboardArea = fillTheCupboardArea(scanner, rows, cols);
        int[] pos = findInitialPos(cupboardArea);
        currentRowPos = pos[0];
        currentColPos = pos[1];
        cheeseCount = getCountCheese();

        String command = scanner.nextLine();
        while (!"danger".equals(command)) {
            cupboardArea[currentRowPos][currentColPos] = "*";
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
            cupboardArea[currentRowPos][currentColPos] = "M";
            if (isOutOfBoundaries) {
                System.out.println("No more cheese for tonight!");
                printCupboardArea();
                return;
            }
            if (allCheeseIsFound) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                printCupboardArea();
                return;
            }
            if (isTrapped) {
                System.out.println("Mouse is trapped!");
                printCupboardArea();
                return;
            }


            command = scanner.nextLine();
        }

        System.out.println("Mouse will come back later!");
        printCupboardArea();

    }

    private static void moveUp() {
        currentRowPos -= 1;

        if (currentRowPos < 0) {
            currentRowPos += 1;
            isOutOfBoundaries = true;
        } else if (cupboardArea[currentRowPos][currentColPos].equals("@")) {
            currentRowPos += 1;
        }

    }

    private static void moveDown() {
        currentRowPos += 1;

        if (currentRowPos >= cupboardArea.length) {
            currentRowPos -= 1;
            isOutOfBoundaries = true;
        }else if (cupboardArea[currentRowPos][currentColPos].equals("@")) {
            currentRowPos -= 1;
        }
    }

    private static void moveLeft() {
        currentColPos -= 1;

        if (currentColPos < 0) {
            currentColPos += 1;
            isOutOfBoundaries = true;
        } else if (cupboardArea[currentRowPos][currentColPos].equals("@")) {
            currentColPos += 1;
        }
    }

    private static void moveRight() {
        currentColPos += 1;

        if (currentColPos >= cupboardArea[currentRowPos].length) {
            currentColPos -= 1;
            isOutOfBoundaries = true;
        } else if (cupboardArea[currentRowPos][currentColPos].equals("@")) {
            currentColPos -= 1;
        }
    }

    private static void checkPos() {
        if (cupboardArea[currentRowPos][currentColPos].equals("C")) {
            cheeseCount--;
            if (cheeseCount == 0) {
                allCheeseIsFound = true;
            }
        } else if (cupboardArea[currentRowPos][currentColPos].equals("T")) {
            isTrapped = true;
        }
    }

    private static void printCupboardArea () {
        for (String[] row : cupboardArea) {
            System.out.println(Arrays.toString(row).replaceAll("[]\\[,\\s]", ""));
        }
    }

    private static String[][] fillTheCupboardArea (Scanner scanner, int rows, int cols) {
        String[][] cupboardArea = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            cupboardArea[row] = scanner.nextLine().split("");
        }

        return cupboardArea;
    }

    private static int[] findInitialPos (String[][] matrix) {
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("M")) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }

        return pos;
    }
    private static int getCountCheese() {
        int count = 0;
        for (int i = 0; i < cupboardArea.length; i++) {
            for (int j = 0; j < cupboardArea[i].length; j++) {
                if (cupboardArea[i][j].equals("C")) {
                    count++;
                }
            }
        }

        return count;
    }
}
