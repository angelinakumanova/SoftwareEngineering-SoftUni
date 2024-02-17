package AlgorithmsWorkShop;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(calcFactorial(number));
    }

    private static int calcFactorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * calcFactorial(number - 1);
    }
}
