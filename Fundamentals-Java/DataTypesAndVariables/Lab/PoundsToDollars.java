package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double poundsToDollars = Double.parseDouble(scanner.nextLine()) * 1.36;
        System.out.printf("%.3f", poundsToDollars);
    }
}
