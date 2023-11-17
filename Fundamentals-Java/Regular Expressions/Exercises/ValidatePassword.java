package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern validPattern = Pattern.compile("(\\b_([.]+)([A-Z][A-Za-z0-9]{4,}[A-Z])_([.]+))");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher validMatcher = validPattern.matcher(input);
            if (validMatcher.find()) {
                Pattern numsPattern = Pattern.compile("\\d");
                Matcher numsMatcher = numsPattern.matcher(input);
                if (numsMatcher.find()) {
                    System.out.print("Group: ");
                    numsMatcher = numsPattern.matcher(input);
                    while (numsMatcher.find()) {
                        System.out.print(numsMatcher.group());
                    }
                    System.out.println();
                } else {
                    System.out.println("Group: default");
                }
            } else {
                System.out.println("Invalid pass!");
            }
        }

    }
}
