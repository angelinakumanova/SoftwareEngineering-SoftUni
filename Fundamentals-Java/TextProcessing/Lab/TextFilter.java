package TextProcessing.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            if (text.contains(bannedWords[i])) {
                char[] wordReplacement = new char[bannedWords[i].length()];
                Arrays.fill(wordReplacement, '*');
                String replacement = String.valueOf(wordReplacement);
                text = text.replace(bannedWords[i], replacement);
            }
        }

        System.out.println(text);
    }
}
