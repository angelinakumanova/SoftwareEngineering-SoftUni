package TextProcessing.Lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            char[] letters = input.toCharArray();
            String reversedWord = "";
            for (int i = letters.length - 1; i >= 0; i--) {
                reversedWord += letters[i];
            }
            System.out.println(input + " = " + reversedWord);

            input = scanner.nextLine();
        }
    }
}
