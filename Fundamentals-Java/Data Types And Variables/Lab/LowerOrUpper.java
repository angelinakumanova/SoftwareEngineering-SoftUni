package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);
        if (Character.isUpperCase(input)) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
