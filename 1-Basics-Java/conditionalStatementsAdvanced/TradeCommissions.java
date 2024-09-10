package conditionalStatementsAdvanced;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        boolean first = (sales >= 0 && sales <= 500);
        boolean second = (sales > 500 && sales <= 1000);
        boolean third = (sales > 1000 && sales <= 10000);
        boolean fourth = (sales > 10000);

        double result = 0.0;

        boolean isValidCity = "Sofia".equals(city) || "Varna".equals(city) || "Plovdiv".equals(city);

        if (isValidCity && sales > 0) {
            switch (city) {
                case "Sofia":
                    if (first) {
                        result = sales * 5 / 100;
                    } else if (second) {
                        result = sales * 7 / 100;
                    } else if (third) {
                        result = sales * 8 / 100;
                    } else if (fourth) {
                        result = sales * 12 / 100;
                    }
                    break;
                case "Varna":
                    if (first) {
                        result = sales * 4.5 / 100;
                    } else if (second) {
                        result = sales * 7.5 / 100;
                    } else if (third) {
                        result = sales * 10 / 100;
                    } else if (fourth) {
                        result = sales * 13 / 100;
                    }
                    break;
                case "Plovdiv":
                    if (first) {
                        result = sales * 5.5 / 100;
                    } else if (second) {
                        result = sales * 8 / 100;
                    } else if (third) {
                        result = sales * 12 / 100;
                    } else if (fourth) {
                        result = sales * 14.5 / 100;
                    }
                    break;
            }System.out.printf("%.2f", result);
            } else {
            System.out.println("error");
        }
    }
}
