package Methods.Exercises;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        countVowels(input);
    }

    public static void countVowels(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            String[] letters = input.split("");
            if (letters[i].equalsIgnoreCase("a") || letters[i].equalsIgnoreCase("o") ||
                    letters[i].equalsIgnoreCase("u") || letters[i].equalsIgnoreCase("e") ||
                    letters[i].equalsIgnoreCase("i")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
