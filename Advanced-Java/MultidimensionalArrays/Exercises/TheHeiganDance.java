package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    private static int[] posOfPlayer = {7, 7};
    private static int playerHitPoints = 18_500;
    private static double heiganHitPoints = 3_000_000;
    private static boolean cloudIsActive = false;
    private static String lastSpell = null;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageDoneToHeigan = Double.parseDouble(scanner.nextLine());

        while (playerHitPoints > 0 && heiganHitPoints > 0) {
            String[] heiganAttack = scanner.nextLine().split("\\s+");

            String spell = heiganAttack[0];
            int row = Integer.parseInt(heiganAttack[1]);
            int col = Integer.parseInt(heiganAttack[2]);

            heiganHitPoints -= damageDoneToHeigan;


            if (cloudIsActive) {
                playerHitPoints -= 3500;
                cloudIsActive = false;

                if (playerHitPoints <= 0) {
                    lastSpell = "Plague Cloud";
                    break;
                }
            }

            if (heiganHitPoints < 0) {
                break;
            }

            int[][] battleField = new int[15][15];
            if (spell.equals("Cloud") && playerHitPoints > 0) {
                lastSpell = "Plague Cloud";
                battleFieldDamage(battleField, row, col);

                if (battleField[posOfPlayer[0]][posOfPlayer[1]] == -1) {
                    int[] currentPos = movePlayer(battleField);
                    if (Arrays.equals(currentPos, posOfPlayer)) {
                        cloudIsActive = true;
                        playerHitPoints -= 3500;
                    } else {
                        posOfPlayer = currentPos;
                    }
                }
            } else if (spell.equals("Eruption") && playerHitPoints > 0) {
                lastSpell = spell;
                battleFieldDamage(battleField, row, col);

                if (battleField[posOfPlayer[0]][posOfPlayer[1]] == -1) {
                    int[] currentPos = movePlayer(battleField);
                    if (Arrays.equals(currentPos, posOfPlayer)) {
                        playerHitPoints -= 6000;
                    } else {
                        posOfPlayer = currentPos;
                    }
                }
            }
        }
        printFinalResult();
    }

    private static int[] movePlayer(int[][] battleField) {
        int pRow = posOfPlayer[0];
        int pCol = posOfPlayer[1];

        if (pRow - 1 >= 0 && battleField[pRow - 1][pCol] != -1) {
            return new int[]{pRow - 1, pCol};
        } else if (pCol + 1 < battleField.length && battleField[pRow][pCol + 1] != -1) {
            return new int[]{pRow, pCol + 1};
        } else if (pRow + 1 < battleField.length && battleField[pRow + 1][pCol] != -1) {
            return new int[]{pRow + 1, pCol};
        } else if (pCol - 1 >= 0 && battleField[pRow][pCol - 1] != -1) {
            return new int[]{pRow, pCol - 1};
        }

        return new int[]{pRow, pCol};
    }

    private static void battleFieldDamage(int[][] battleField, int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < battleField.length) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j >= 0 && j < battleField[row].length) {
                        battleField[i][j] = -1;
                    }
                }
            }
        }
    }

    private static void printFinalResult() {
        if (heiganHitPoints < 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        }
        if (playerHitPoints < 0) {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHitPoints);
        }
        System.out.printf("Final position: %d, %d%n", posOfPlayer[0], posOfPlayer[1]);
    }
}
