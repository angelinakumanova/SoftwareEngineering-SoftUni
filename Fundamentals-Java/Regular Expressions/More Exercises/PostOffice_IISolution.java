package RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice_IISolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputParts = scanner.nextLine().split("\\|");
        Pattern firstPattern = Pattern.compile("([#$%*&])(?<capitals>[A-Z]+)(\\1)");
        Matcher firstMatcher = firstPattern.matcher(inputParts[0]);

        if (firstMatcher.find()) {
            char[] letters = firstMatcher.group("capitals").toCharArray();

            for (int i = 0; i < letters.length; i++) {
                int asciiCode = letters[i];

                Pattern secondPattern = Pattern.compile(asciiCode + ":(?<length>\\d{2})");
                Matcher secondMatcher = secondPattern.matcher(inputParts[1]);
                int length = 0;
                if (secondMatcher.find()) {
                    length = Integer.parseInt(secondMatcher.group("length"));
                }

                Pattern thirdPattern = Pattern.compile("(?<=\\s|^)" + letters[i] + "\\S{" + length + "}\\b");
                Matcher thirdMatcher = thirdPattern.matcher(inputParts[2]);
                if (thirdMatcher.find()) {
                    System.out.println(thirdMatcher.group());
                }



            }
        }

    }
}
