package forlab;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int leftResult = 0;
        int rightResult = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            leftResult += number;
        }
        for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(scanner.nextLine());
                rightResult += number;
        }
        if (leftResult == rightResult) {
            System.out.println("Yes, sum = " + leftResult);
        } else {
            System.out.println("No, diff = " + Math.abs(leftResult - rightResult));
        }
    }
}
