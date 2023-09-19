package additionalexcs;

import java.util.Scanner;

public class circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());

        double perimeter = 2 * Math.PI * r;
        double area = Math.PI * r * r;

        System.out.printf("%.2f \n", area);
        System.out.printf("%.2f", perimeter);
    }
}
