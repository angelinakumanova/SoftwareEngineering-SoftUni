package Methods.Lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            printRow(i);
        }
        for (int i = n - 1; i >= 1 ; i--) {
            printRow(i);
        }

    }

    public static void printRow(int elementsCount) {
        for (int i = 1; i <= elementsCount ; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
