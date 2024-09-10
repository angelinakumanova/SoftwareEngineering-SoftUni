package Methods.Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        if (type.equals("int")) {
            int firstNumber = Integer.parseInt(scanner.nextLine());
            int secondNumber = Integer.parseInt(scanner.nextLine());

            System.out.println(getMax(firstNumber, secondNumber));
        } else if (type.equals("char")) {
            char firstCh = scanner.nextLine().charAt(0);
            char secondCh = scanner.nextLine().charAt(0);

            System.out.println(getMax(firstCh, secondCh));
        } else if (type.equals("string")) {
            String firstStr = scanner.nextLine();
            String secondStr = scanner.nextLine();

            System.out.println(getMax(firstStr, secondStr));
        }
    }

    public static int getMax (int a, int b) {
        if (a > b) {
            return a;
        }

        return b;
    }

    public static char getMax (char a, char b) {
        if (a > b) {
            return a;
        }

        return b;
    }
    public static String getMax (String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) >= 0) {
            return firstStr;
        }

        return secondStr;
    }
}
