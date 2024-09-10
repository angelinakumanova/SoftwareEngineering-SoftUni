package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = fillTheMatrix(scanner);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessBoard[row][col] == 'q') {
                    if (checkIfItIsTheQueen(chessBoard, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static char[][] fillTheMatrix (Scanner scanner) {
        char[][] array = new char[8][8];

        for (int row = 0; row < 8; row++) {
            array[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return array;
    }

    private static boolean checkIfItIsTheQueen (char[][] chessBoard, int row, int col) {

        // Right horizontal check
        for (int i = col + 1; i < 8; i++) {
            if (chessBoard[row][i] == 'q') {
                return false;
            }
        }

        // Left horizontal check
        for (int i = 0; i < col; i++) {
            if (chessBoard[row][i] == 'q') {
                return false;
            }
        }

        // Up vertical check
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'q') {
                return false;
            }
        }

        // Down vertical check
        for (int i = row + 1; i < 8; i++) {
            if (chessBoard[i][col] == 'q') {
                return false;
            }
        }

        // Upper-left diagonal check
        int upperLeftCol = col - 1;

        for (int i = row - 1; i >= 0 && upperLeftCol >= 0; i--, upperLeftCol--) {
            if (chessBoard[i][upperLeftCol] == 'q') {
                return false;
            }
        }

        // Upper-right diagonal check
        int upperRightCol = col + 1;

        for (int i = row - 1; i >= 0 && upperRightCol <= 7 ; i--, upperRightCol++) {
            if (chessBoard[i][upperRightCol] == 'q') {
                return false;
            }
        }

        // Down left diagonal
        int downLeftCol = col - 1;

        for (int i = row + 1; i <= 7 && downLeftCol >= 0 ; i++, downLeftCol--) {
            if (chessBoard[i][downLeftCol] == 'q') {
                return false;
            }
        }

        //Down right diagonal
        int downRightCol = col + 1;

        for (int i = row + 1; i <= 7 && downRightCol <= 7 ; i++, downRightCol++) {
            if (chessBoard[i][downRightCol] == 'q') {
                return false;
            }
        }

        return true;
    }
}
