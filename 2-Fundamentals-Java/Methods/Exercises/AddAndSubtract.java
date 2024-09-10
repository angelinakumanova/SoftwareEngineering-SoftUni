package Methods.Exercises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        System.out.println(sumsFirstTwoIntegers(a, b) - c);
    }

    public static int sumsFirstTwoIntegers(int a, int b) {
        return a + b;
    }


}
