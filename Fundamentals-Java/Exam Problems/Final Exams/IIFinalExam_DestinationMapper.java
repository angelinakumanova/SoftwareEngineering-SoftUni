package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IIFinalExam_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])(?<loc>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        int sum = 0;
        List<String> locations = new ArrayList<>();
        while (matcher.find()) {
            sum += matcher.group("loc").length();
            locations.add(matcher.group("loc"));
        }
        System.out.printf("Destinations: %s%n", String.join(", ", locations));
        System.out.printf("Travel Points: %d%n", sum);
    }
}
