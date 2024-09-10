package Methods.Exercises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            checkNumber(input);

            input = scanner.nextLine();
        }
    }

    public static void checkNumber(String input) {
        String[] elements = input.split("");
        String numberBackwards = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            numberBackwards += elements[i];
        }
        if (numberBackwards.equals(input)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
