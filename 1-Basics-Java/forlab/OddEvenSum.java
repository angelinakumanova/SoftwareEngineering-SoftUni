package forlab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int evenResult = 0;
        int oddResult = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evenResult += number;
            } else {
                oddResult += number;
            }
        }

            if (evenResult == oddResult) {
                System.out.println("Yes");
                System.out.println("Sum = " + evenResult);
            } else {
                System.out.println("No");
                System.out.println("Diff = " + Math.abs(evenResult - oddResult));
            }
    }
}
