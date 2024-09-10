package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rangeStart = Integer.parseInt(scanner.nextLine());
        int rangeEnd = Integer.parseInt(scanner.nextLine());

        for (int i = rangeStart; i <= rangeEnd ; i++) {
            System.out.printf((char) i + " ");
        }
    }
}
