package BasicSyntax_ConditionalStatements_Loops.Lab;

import java.util.Scanner;

public class MultiplicationTableII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());
        do {
            System.out.println(number + " X " + multiplier + " = " + number * multiplier);
            multiplier++;
        } while (multiplier <= 10);

    }
}
