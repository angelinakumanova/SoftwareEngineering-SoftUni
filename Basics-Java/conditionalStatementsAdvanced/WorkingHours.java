package conditionalStatementsAdvanced;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        String dayOfTheWeek = scanner.nextLine();
        boolean openDays = "Monday".equals(dayOfTheWeek) || "Tuesday".equals(dayOfTheWeek)
                || "Wednesday".equals(dayOfTheWeek) || "Thursday".equals(dayOfTheWeek) || "Friday".equals(dayOfTheWeek)
                || "Saturday".equals(dayOfTheWeek);
        if (!openDays) {
            System.out.println("closed");
        } else {
        if (hour >= 10 && hour <= 18)  {
            System.out.println("open");
        } else {
            System.out.println("closed");
        }

        }
    }
}
