package Methods.MoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        if (type.equals("int")) {
            int number = Integer.parseInt(scanner.nextLine());
            print(number);
        } else if (type.equals("real")) {
            double number = Double.parseDouble(scanner.nextLine());
            print(number);
        } else if (type.equals("string")) {
            String input = scanner.nextLine();
            print(input);
        }
    }

    public static void print(int number) {
        System.out.println(number * 2);
    }

    public static void print(double number) {
        System.out.printf("%.2f", number * 1.5);
    }

    public static void print(String input) {
        System.out.println("$" + input + "$");
    }
}
