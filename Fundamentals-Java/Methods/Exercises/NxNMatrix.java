package Methods.Exercises;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        makeMatrix(n);

    }

    public static void makeMatrix(int n) {
        for (int cols = 0; cols < n; cols++) {
            for (int rows = 0; rows < n; rows++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
