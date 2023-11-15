package Exams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IFinalExam_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<food>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<cals>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group("cals"));
        }

        System.out.printf("You have food to last you for: %d days!%n", sum / 2000);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",
                    matcher.group("food"),
                    matcher.group("date"),
                    matcher.group("cals"));
        }
    }
}
