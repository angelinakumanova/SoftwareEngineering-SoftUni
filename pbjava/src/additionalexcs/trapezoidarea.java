package additionalexcs;

import java.util.Scanner;

public class trapezoidarea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double b1 = Double.parseDouble(scanner.nextLine());
        double b2 = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double sum = (b1 + b2) / 2.0 * h;

        System.out.printf("%.2f", sum);
    }
}
