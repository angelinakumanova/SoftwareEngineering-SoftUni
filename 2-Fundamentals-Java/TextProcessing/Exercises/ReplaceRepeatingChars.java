package TextProcessing.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] letters = text.toCharArray();
        List<Character> lettersList = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            lettersList.add(letters[i]);
        }

        for (int i = 1; i < lettersList.size(); i++) {
            char previous = lettersList.get(i - 1);
            char current = lettersList.get(i);

            if (previous == current) {
                lettersList.remove(i);
                i--;
            }
        }
        for (Character character : lettersList) {
            System.out.print(character);
        }
    }
}
