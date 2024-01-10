package DataTypesAndVariables.Exercises.MoreExercises;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int countLeftBracket = 0;
        int countRightBracket = 0;

        for (int i = 1; i <= lines; i++) {
            String input = scanner.nextLine();
            if (i == 1 &&input.equals(")")) {
                System.out.println("UNBALANCED");
                return;
            }
            if (input.equals("(")) {
                countLeftBracket++;
            } else if (input.equals(")")) {
                countRightBracket++;
                if (countLeftBracket - countRightBracket != 0) {
                    System.out.println("UNBALANCED");
                    return;
                }
            }
        }
        if (countLeftBracket == countRightBracket) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }

        }

}

