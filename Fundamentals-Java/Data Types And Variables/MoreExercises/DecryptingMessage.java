package DataTypesAndVariables.Exercises.MoreExercises;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int nCharacters = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int i = 0; i < nCharacters; i++) {
            char letter = scanner.nextLine().charAt(0);
            int sumOfLetters = key + letter;
            message = String.format(String.valueOf((char) sumOfLetters) );
            System.out.print(message);
            sumOfLetters = 0;
        }

    }
}
