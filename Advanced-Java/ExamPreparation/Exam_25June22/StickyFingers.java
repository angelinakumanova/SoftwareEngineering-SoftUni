package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    private static String[][] field;
    private static int currentRowPos;
    private static int currentColPos;
    private static int stolenMoney;
    private static boolean isCaught = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        field = fillTheField(scanner, size);
        field[currentRowPos][currentColPos] = "+";
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "up":
                    currentRowPos--;
                    if (currentRowPos < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentRowPos++;
                        break;
                    }
                    checkPos();
                    break;
                case "down":
                    currentRowPos++;
                    if (currentRowPos == field.length) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentRowPos--;
                        break;
                    }
                    checkPos();
                    break;
                case "left":
                    currentColPos--;
                    if (currentColPos < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentColPos++;
                        break;
                    }
                    checkPos();
                    break;
                case "right":
                    currentColPos++;
                    if (currentColPos == field.length) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentColPos--;
                        break;
                    }
                    checkPos();
                    break;
            }

            if (isCaught) {
                field[currentRowPos][currentColPos] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                printField();
                return;
            }
        }

        field[currentRowPos][currentColPos] = "D";
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        printField();

    }

    private static String[][] fillTheField(Scanner scanner, int size) {
        String[][] field = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                field[row][col] = input[col];
                if (input[col].equals("D")) {
                    currentRowPos = row;
                    currentColPos = col;
                }
            }
        }

        return field;
    }

    private static void checkPos() {
        if (field[currentRowPos][currentColPos].equals("$")) {
            field[currentRowPos][currentColPos] = "+";
            int currentStolenMoney = currentRowPos * currentColPos;
            System.out.printf("You successfully stole %d$.%n", currentStolenMoney);
            stolenMoney += currentStolenMoney;
        } else if (field[currentRowPos][currentColPos].equals("P")) {
            isCaught = true;
        }
    }

    private static void printField() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }

}
