package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double spent = 0;

        while (!input.equals("Game Time")) {
            if (input.equals("OutFall 4")) {
                balance -= 39.99;
                spent += 39.99;

                if (balance < 0) {
                    System.out.println("Too Expensive");
                    balance += 39.99;
                    spent -= 39.99;
                } else {
                    System.out.println("Bought OutFall 4");
                }

            } else if (input.equals("CS: OG")) {
                balance -= 15.99;
                spent += 15.99;

                if (balance < 0) {
                    System.out.println("Too Expensive");
                    balance += 15.99;
                    spent -= 15.99;
                } else {
                    System.out.println("Bought CS: OG");
                }
            } else if (input.equals("Zplinter Zell")) {
                balance -= 19.99;
                spent += 19.99;

                if (balance < 0) {
                    System.out.println("Too Expensive");
                    balance += 19.99;
                    spent -= 19.99;
                } else {
                    System.out.println("Bought Zplinter Zell");
                }
            } else if (input.equals("Honored 2")) {
                balance -= 59.99;
                spent += 59.99;

                if (balance < 0) {
                    System.out.println("Too Expensive");
                    balance += 59.99;
                    spent -= 59.99;
                } else {
                    System.out.println("Bought Honored 2");
                }
            } else if (input.equals("RoverWatch")) {
                balance -= 29.99;
                spent += 29.99;

                if (balance < 0) {
                    System.out.println("Too Expensive");
                    balance += 29.99;
                    spent -= 29.99;
                } else {
                    System.out.println("Bought RoverWatch");
                }
            } else if (input.equals("RoverWatch Origins Edition")) {
                balance -= 39.99;
                spent += 39.99;

                if (balance < 0) {
                    System.out.println("Too Expensive");
                    balance += 39.99;
                    spent -= 39.99;
                } else {
                    System.out.println("Bought RoverWatch Origins Edition");
                }
            } else {
                System.out.println("Not Found");
            }
            if (balance <= 0) {
                System.out.println("Out of money!");
                break;
            } else {

            }
            input = scanner.nextLine();
        }
        if (balance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, balance);
        }
    }
}
