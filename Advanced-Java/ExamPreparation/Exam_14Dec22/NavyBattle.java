package Exams.Exam_14Dec22;

import java.util.Scanner;

public class NavyBattle {
    private static char[][] battlefield;
    private static int currentRowPos;
    private static int currentColPos;
    private static int countHitMines;
    private static int countDestroyedCruisers;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        battlefield = fillTheBattlefield(scanner, size);


        while (countHitMines < 3 && countDestroyedCruisers < 3) {
            String command = scanner.nextLine();
            battlefield[currentRowPos][currentColPos] = '-';
            switch (command) {
                case "up":
                    currentRowPos--;
                    checkPos();
                    break;
                case "down":
                    currentRowPos++;
                    checkPos();
                    break;
                case "left":
                    currentColPos--;
                    checkPos();
                    break;
                case "right":
                    currentColPos++;
                    checkPos();
                    break;
            }
            battlefield[currentRowPos][currentColPos] = 'S';
        }

        System.out.println(countDestroyedCruisers == 3 ? "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!"
                : String.format("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!", currentRowPos, currentColPos));
        printBattlefield();
    }

    private static void checkPos() {
        if (battlefield[currentRowPos][currentColPos] == '*') {
            countHitMines++;
        } else if (battlefield[currentRowPos][currentColPos] == 'C') {
            countDestroyedCruisers++;
        }
    }

    private static char[][] fillTheBattlefield (Scanner scanner, int size) {
        char[][] battlefield = new char[size][size];

        for (int row = 0; row < size; row++) {
            String rowInput = scanner.nextLine();
            for (int i = 0; i < rowInput.length(); i++) {
                battlefield[row][i] = rowInput.charAt(i);
                if (rowInput.charAt(i) == 'S') {
                    currentRowPos = row;
                    currentColPos = i;
                }
            }
        }

        return battlefield;
    }
    private static void printBattlefield() {
        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield.length; col++) {
                System.out.print(battlefield[row][col]);
            }
            System.out.println();
        }
    }
}
