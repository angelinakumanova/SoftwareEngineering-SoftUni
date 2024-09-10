package ExamPreparation.Exam_22Oct22;

import java.util.Scanner;

public class RallyRacing {
    private static String[][] route;
    private static int currentRowPos = 0;
    private static int currentColPos = 0;
    private static int[] firstTunnelPos = {-1, -1};
    private static int[] secondTunnelPos = new int[2];
    private static int totalKilometres;
    private static boolean isFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String car = scanner.nextLine();
        route = fillTheRoute(scanner, size);


        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            route[currentRowPos][currentColPos] = ".";
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

            if (isFinished) {
                route[currentRowPos][currentColPos] = "C";
                System.out.printf("Racing car %s finished the stage!%n", car);
                System.out.printf("Distance covered %d km.%n", totalKilometres);
                printRoute();
                return;
            }
            command = scanner.nextLine();
        }

        route[currentRowPos][currentColPos] = "C";
        System.out.printf("Racing car %s DNF.%n", car);
        System.out.printf("Distance covered %d km.%n", totalKilometres);
        printRoute();
    }

    private static String[][] fillTheRoute(Scanner scanner, int size) {
        String[][] route = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                route[row][col] = input[col];
                if (input[col].equals("T")) {
                    if (firstTunnelPos[0] == -1) {
                        firstTunnelPos[0] = row;
                        firstTunnelPos[1] = col;
                    } else {
                        secondTunnelPos[0] = row;
                        secondTunnelPos[1] = col;
                    }
                }
            }
        }

        return route;
    }

    private static void checkPos() {
        if (route[currentRowPos][currentColPos].equals("T")) {
            route[currentRowPos][currentColPos] = ".";
            totalKilometres += 30;
            if (currentRowPos == firstTunnelPos[0]) {
                currentRowPos = secondTunnelPos[0];
                currentColPos = secondTunnelPos[1];
            } else {
                currentRowPos = firstTunnelPos[0];
                currentColPos = firstTunnelPos[1];
            }
        } else if (route[currentRowPos][currentColPos].equals("F")) {
            totalKilometres += 10;
            isFinished = true;
        } else if (route[currentRowPos][currentColPos].equals(".")) {
            totalKilometres += 10;
        }
    }

    private static void printRoute() {
        for (int row = 0; row < route.length; row++) {
            for (int col = 0; col < route.length; col++) {
                System.out.print(route[row][col]);
            }
            System.out.println();
        }
    }
}
