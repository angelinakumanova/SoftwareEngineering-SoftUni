package conditionalStatementsAdvanced;

import java.util.Scanner;

public class workingDayOrWeekend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayOfTheWeek = scanner.nextLine();

        boolean isWorkingDay = "Monday".equals(dayOfTheWeek) || "Tuesday".equals(dayOfTheWeek)
                || "Wednesday".equals(dayOfTheWeek) || "Thursday".equals(dayOfTheWeek) || "Friday".equals(dayOfTheWeek);
        boolean isWeekend = "Saturday".equals(dayOfTheWeek) || "Sunday".equals(dayOfTheWeek);
        boolean validDay = isWorkingDay || isWeekend;

        if (!validDay) {
            System.out.println("Error");
        } else {
            switch (dayOfTheWeek) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    System.out.println("Working day");
                    break;
                case "Saturday":
                case "Sunday":
                    System.out.println("Weekend");
                    break;
            }
        }
    }
}
