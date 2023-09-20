package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";
        char pass;

        for (int j = 0; j < username.length() ; j++) {
            pass = username.charAt(j);
            password = pass + password;
        }

        for (int i = 1; i < 5; i++) {
            String inputPassword = scanner.nextLine();
            if (i == 4 && !inputPassword.equals(password)) {
                System.out.printf("User %s blocked!", username);
                break;
            }


            if (inputPassword.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
    }
}
