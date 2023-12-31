package WhileLoops;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int greatestNumber = Integer.MIN_VALUE;

        while (!"Stop".equals(input)) {
            int number = Integer.parseInt(input);
            if (number > greatestNumber) {
                greatestNumber = number;
            }
            input = scanner.nextLine();
        }
        System.out.println(greatestNumber);
    }
}
