package WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(n - i, i);
        }
        for (int i = n - 1; i > 0 ; i--) {
            printRow(n - i, i);
        }
    }

    private static void printRow(int spaceLimit, int starsLimit) {
        for (int spaces = 0; spaces < spaceLimit; spaces++) {
            System.out.print(" ");
        }
        for (int stars = 1; stars <= starsLimit; stars++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
