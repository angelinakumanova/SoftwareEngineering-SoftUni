package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double rageExpenses = 0;
        int countBrokenKeyboard = 0;

        for (int i = 1; i <= lostGamesCount; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                rageExpenses += keyboardPrice + mousePrice + headsetPrice;
                countBrokenKeyboard++;
            } else if (i % 3 == 0) {
                rageExpenses += mousePrice;
            } else if (i % 2 == 0) {
                rageExpenses += headsetPrice;
            }
            if (countBrokenKeyboard == 2) {
                countBrokenKeyboard = 0;
                rageExpenses += displayPrice;
            }

        }
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);

    }
}
