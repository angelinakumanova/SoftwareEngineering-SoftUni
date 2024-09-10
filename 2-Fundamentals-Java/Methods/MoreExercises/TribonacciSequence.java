package Methods.MoreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;
        int n3 = 1;
        int n = Integer.parseInt(scanner.nextLine());

        if (n > 0) {
            System.out.print(1 + " ");
        }

        for (int i = n; i > 1; --i) {
            int sum = n1 + n2 + n3;
            System.out.print(sum + " ");
            n1 = n2;
            n2 = n3;
            n3 = sum;
        }

    }
}
