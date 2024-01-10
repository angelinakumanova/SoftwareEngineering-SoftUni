package TextProcessing.Lab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] symbols = input.toCharArray();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            if (Character.isDigit(symbols[i])) {
                digits.append(symbols[i]);
            } else if (Character.isLetter(symbols[i])) {
                letters.append(symbols[i]);
            } else {
                other.append(symbols[i]);
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);

    }
}
