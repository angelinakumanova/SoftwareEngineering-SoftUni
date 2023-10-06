package Methods.Exercises;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        getMiddleChar(input);
    }

    public static void getMiddleChar (String input) {
        String[] elements = input.split("");
        if (input.length() % 2 == 0) {
            System.out.println(elements[input.length() / 2 - 1] + elements[input.length() / 2]);
        } else {
            System.out.println(elements[input.length() / 2]);
        }
    }
}
