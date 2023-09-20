package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String reversedWord = "";

        for (int position = (word.length() - 1); position >= 0; position--) {
            reversedWord += word.charAt(position);
        }
        System.out.println(reversedWord);
    }
}
