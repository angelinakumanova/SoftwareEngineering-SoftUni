package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = firstNumber; i <= endNumber; i++) {
            System.out.print(i + " ");
            sum += i;

        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
