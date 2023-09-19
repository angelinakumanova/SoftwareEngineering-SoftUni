package additionalexcs;

import java.util.Scanner;

public class trianglearea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double formula = a * h / 2;

        System.out.printf("%.2f", formula);

    }
}
