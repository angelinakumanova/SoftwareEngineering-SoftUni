package conditionalStatementsexcs;

import java.util.Scanner;

public class Sum15Mins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine()) + 15;

        hour = hour + minutes / 60;
        minutes = minutes % 60;

        if (hour >= 24) {
            hour = hour - 24;
        }

        if (minutes < 10) {
            System.out.printf("%d:0%d", hour, minutes);
        } else {
            System.out.printf("%d:%d", hour, minutes);
        }

    }
}
