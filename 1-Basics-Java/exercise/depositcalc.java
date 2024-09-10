package exercise;

import java.util.Scanner;

public class depositcalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int time = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double RatePerMonth = (deposit / 100 * percent) / 12;
        double result = deposit + time * RatePerMonth;

        System.out.println(result);



    }
}
