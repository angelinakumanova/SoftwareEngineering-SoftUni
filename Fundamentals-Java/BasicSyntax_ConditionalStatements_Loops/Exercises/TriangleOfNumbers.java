package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= n; rows++) {
            for (int amountOfNumbers = 1; amountOfNumbers <= rows ; amountOfNumbers++) {
                System.out.print(rows + " ");
            }
            System.out.println();
        }
    }
}
