package TextProcessing.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        List<String> validUsernames = new ArrayList<>();
        for (int i = 0; i < usernames.length; i++) {
            char[] characters = usernames[i].toCharArray();
            boolean isValid = true;
            if (characters.length >= 3 && characters.length <= 16) {
                for (int j = 0; j < characters.length; j++) {
                    if (!(Character.isLetter(characters[j]) ||
                            Character.isDigit(characters[j]) ||
                            characters[j] == 45 || characters[j] == 95)) {
                        isValid = false;
                    }
                }
                if (isValid) {
                    validUsernames.add(usernames[i]);
                }
            }

        }

        for (String username : validUsernames) {
            System.out.println(username);
        }
    }
}
