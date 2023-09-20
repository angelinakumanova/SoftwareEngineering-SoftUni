package BasicSyntax_ConditionalStatements_Loops.Lab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        boolean isEven = false;

        while (!isEven) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 2 == 0) {
                isEven = true;
                System.out.println("The number is: " + Math.abs(number));
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
