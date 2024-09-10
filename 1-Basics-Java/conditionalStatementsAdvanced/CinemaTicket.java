package conditionalStatementsAdvanced;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayOfTheWeek = scanner.nextLine();

        if ("Monday".equals(dayOfTheWeek) || "Tuesday".equals(dayOfTheWeek) || "Friday".equals(dayOfTheWeek)) {
            System.out.println(12);
        }
        if ("Wednesday".equals(dayOfTheWeek) || "Thursday".equals(dayOfTheWeek)) {
            System.out.println(14);
        }
        if ("Saturday".equals(dayOfTheWeek) || "Sunday".equals(dayOfTheWeek)) {
            System.out.println(16);
        }
    }
}
