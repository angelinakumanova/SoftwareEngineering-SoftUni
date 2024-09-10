package exams;

import java.util.Scanner;

public class PINCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxFirst = Integer.parseInt(scanner.nextLine());
        int maxSecond = Integer.parseInt(scanner.nextLine());
        int maxThird = Integer.parseInt(scanner.nextLine());
        String PINCode = "";

        for (int i = 2; i <= maxFirst; i++) {
            for (int j = 2; j <= maxSecond; j++) {
                for (int k = 2; k <= maxThird; k++) {
                    if (j >= 2 && j <= 7 && j != 4 && j != 6 && i % 2 == 0 && k % 2 == 0) {
                        System.out.printf("%d %d %d%n", i, j, k);

                    }
                }
            }
        }
    }
}
