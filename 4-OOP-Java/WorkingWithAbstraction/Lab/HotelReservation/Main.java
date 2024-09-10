package WorkingWithAbstraction.Lab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split("\\s+");

        double price = Double.parseDouble(info[0]);
        int numberOfDays = Integer.parseInt(info[1]);
        int multiplier = Season.valueOf(info[2].toUpperCase()).getIndex();
        double discount = Discount.getType(info[3]).getDiscount();

        System.out.printf("%.2f", new PriceCalculator(price, numberOfDays, multiplier, discount).calculatePrice());
    }
}
