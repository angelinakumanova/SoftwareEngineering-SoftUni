package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nOrders = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 0; i < nOrders; i++) {
            double pricerPerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double priceOfACoffee = ((days * capsulesCount) * pricerPerCapsule);
            totalPrice += priceOfACoffee;
            System.out.printf("The price for the coffee is: $%.2f%n", priceOfACoffee);
        }
        System.out.printf("Total: $%.2f", totalPrice);

    }
}
