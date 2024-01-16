package Exams.Exam_13Dec23;

import java.util.Arrays;
import java.util.Scanner;

public class TheGambler {

    private static int initialAmount = 100;
    private static boolean jackpotIsHit = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] gameBoard = fillTheGameBoard(scanner, size);

        int[] initialPos = findingInitialPosition(gameBoard);
        int currentRowPos = initialPos[0];
        int currentColPos = initialPos[1];

        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            if (input.equals("up")) {
                if (currentRowPos - 1 < size && currentRowPos - 1 >= 0) {
                    currentRowPos--;
                    checkPos(gameBoard, currentRowPos, currentColPos);

                    gameBoard[currentRowPos + 1][currentColPos] = "-";
                    gameBoard[currentRowPos][currentColPos] = "G";
                    if (jackpotIsHit) {
                        printTheGameBoard(gameBoard);
                        return;
                    } else if (initialAmount <= 0) {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                } else {
                    System.out.println("Game over! You lost everything!");
                    return;
                }
            } else if (input.equals("down")) {
                if (currentRowPos + 1 < size && currentRowPos + 1 >= 0) {
                    currentRowPos++;
                    checkPos(gameBoard, currentRowPos, currentColPos);

                    gameBoard[currentRowPos - 1][currentColPos] = "-";
                    gameBoard[currentRowPos][currentColPos] = "G";
                    if (jackpotIsHit) {
                        printTheGameBoard(gameBoard);
                        return;
                    } else if (initialAmount <= 0) {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                } else {
                    System.out.println("Game over! You lost everything!");
                    return;
                }
            } else if (input.equals("left")) {
                if (currentColPos - 1 < size && currentColPos - 1 >= 0) {
                    currentColPos--;
                    checkPos(gameBoard, currentRowPos, currentColPos);

                    gameBoard[currentRowPos][currentColPos + 1] = "-";
                    gameBoard[currentRowPos][currentColPos] = "G";
                    if (jackpotIsHit) {
                        printTheGameBoard(gameBoard);
                        return;
                    } else if (initialAmount <= 0) {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                } else {
                    System.out.println("Game over! You lost everything!");
                    return;
                }
            } else if (input.equals("right")) {
                if (currentColPos + 1 < size && currentColPos + 1 >= 0) {
                    currentColPos++;
                    checkPos(gameBoard, currentRowPos, currentColPos);

                    gameBoard[currentRowPos][currentColPos - 1] = "-";
                    gameBoard[currentRowPos][currentColPos] = "G";
                    if (jackpotIsHit) {
                        printTheGameBoard(gameBoard);
                        return;
                    } else if (initialAmount <= 0) {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                } else {
                    System.out.println("Game over! You lost everything!");
                    return;
                }
            }


            input = scanner.nextLine();
        }

        System.out.printf("End of the game. Total amount: %d$%n", initialAmount);
        printTheGameBoard(gameBoard);

    }

    private static String[][] fillTheGameBoard (Scanner scanner, int size) {
        String[][] game = new String[size][size];

        for (int row = 0; row < size; row++) {
            game[row] = scanner.nextLine().split("");
        }

        return game;
    }

    private static int[] findingInitialPosition (String[][] matrix) {
        int[] pos = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("G")) {
                    pos[0] = row;
                    pos[1] = col;
                    break;
                }
            }
        }

        return pos;
    }

    private static void checkPos (String[][] gameBoard, int currentRowPos, int currentColPos) {
        if (gameBoard[currentRowPos][currentColPos].equals("W")) {
            initialAmount += 100;
        } else if (gameBoard[currentRowPos][currentColPos].equals("P")) {
            initialAmount -= 200;
        } else if (gameBoard[currentRowPos][currentColPos].equals("J")) {
            initialAmount += 10000;
            System.out.printf("You win the Jackpot!\n" +
                    "End of the game. Total amount: %d$\n", initialAmount);
            jackpotIsHit = true;
        }
    }


    private static void printTheGameBoard(String[][] gameBoard) {
        for (int row = 0; row < gameBoard.length; row++) {
            System.out.println(Arrays.toString(gameBoard[row]).replaceAll("[\\[,\\]\\s]", ""));
        }
    }
}
