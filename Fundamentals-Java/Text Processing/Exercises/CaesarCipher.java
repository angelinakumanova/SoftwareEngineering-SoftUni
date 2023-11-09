package TextProcessing.Exercises;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] letters = text.toCharArray();
        for (int j = 0; j < letters.length; j++) {
            letters[j] = (char) (letters[j] + 3);
            result.append(letters[j]);
        }

        System.out.println(result);
    }
}
