package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        String type = "";


        double priceSt = 0.0;
        double priceApart = 0.0;
        switch (month) {
            case "May":
            case "October":
                type = "Studio";
                priceSt = 50 * nights;
                type = "Apartment";
                priceApart = 65 * nights;
                break;
            case "June":
            case "September":
                type = "Studio";
                priceSt = 75.20 * nights;
                type = "Apartmnet";
                priceApart = 68.70 * nights;
                break;
            case "July":
            case "August":
                type = "Studio";
                priceSt = 76 * nights;
                type = "Apartment";
                priceApart = 77 * nights;
                break;
        }
        if (month.equals("May") || month.equals("October")) {
            if (nights > 7 && nights <= 13) {
                priceSt *= 0.95;
            } else if (nights > 14) {
                priceSt *= 0.70;
            }
        }
           if (month.equals("June") || month.equals("September")) {
               if (nights > 14) {
                   priceSt *= 0.80;
               }
           } if (nights > 14) {
               priceApart *= 0.90;
        }
        System.out.printf("Apartment: %.2f lv.%n", priceApart);
        System.out.printf("Studio: %.2f lv.", priceSt);





    }
}
