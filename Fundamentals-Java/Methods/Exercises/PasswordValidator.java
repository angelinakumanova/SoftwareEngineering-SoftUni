package Methods.Exercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (checkCharacters(password) && checkLettersAndDigits(password) && checkTwoDigits(password)) {
            System.out.println("Password is valid");
        }
        if (!checkCharacters(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!checkTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

    }

    public static boolean checkCharacters(String password) {
        boolean isValid = false;
        if (password.length() >= 6 && password.length() <= 10) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean checkLettersAndDigits(String password) {
        boolean isValid = false;

        for (int i = 0; i < password.length(); i++) {
            String[] letters = password.split("");
            char letter = letters[i].charAt(0);

            if (letter >= 48 && letter <= 57 || letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122) {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static boolean checkTwoDigits(String password) {
        boolean isValid = false;
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            String[] letters = password.split("");
            char letter = letters[i].charAt(0);

            if (letter >= 48 && letter <= 57) {
                count++;
            }
        }
        if (count >= 2) {
            isValid = true;
        }
        return isValid;
    }
}
