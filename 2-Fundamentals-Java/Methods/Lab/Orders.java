package Methods.Lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        calculateFinalPrice(product, quantity);
    }

    public static void calculateFinalPrice(String product, int quantity) {
        if (product.equals("coffee")) {
            System.out.printf("%.2f", quantity * 1.50);
        } else if (product.equals("water")) {
            System.out.printf("%.2f", quantity * 1.00);
        } else if (product.equals("coke")) {
            System.out.printf("%.2f", quantity * 1.40);
        } else if (product.equals("snacks")) {
            System.out.printf("%.2f", quantity * 2.00);
        }
    }
}
