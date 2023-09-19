package lab.firststeps;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sqM = Double.parseDouble(scanner.nextLine());
        double priceperSqM = 7.61;
        double price = sqM * priceperSqM;
        double discount = price * 0.18;
        double finalprice = price - discount;

        System.out.println("The final price is: " + finalprice + " lv.");
        System.out.println("The discount is: " + discount + " lv.");

    }
}
