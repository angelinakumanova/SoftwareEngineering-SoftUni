package WhileLoops;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int smallestNumber = Integer.MAX_VALUE;

        while (!"Stop".equals(input)) {
            int number = Integer.parseInt(input);

            if (number < smallestNumber) {
                smallestNumber = number;
            }
            input = scanner.nextLine();
        }
        System.out.println(smallestNumber);
    }
}
