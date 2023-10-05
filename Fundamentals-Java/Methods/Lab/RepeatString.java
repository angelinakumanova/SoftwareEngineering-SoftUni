package Methods.Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        repeatString(input, n);
    }

    public static void repeatString(String input, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(input);
        }
    }
}
