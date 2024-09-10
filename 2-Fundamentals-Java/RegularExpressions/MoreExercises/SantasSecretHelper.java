package RegularExpressions.MoreExercises;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            char[] symbols = input.toCharArray();
            String message = "";
            for (int i = 0; i < symbols.length; i++) {
                message += String.valueOf((char)(symbols[i] - number));
            }

            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behaviour>[GN])!");
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                if (matcher.group("behaviour").equals("G")) {
                    System.out.println(matcher.group("name"));
                }
            }


            input = scanner.nextLine();
        }
    }
}
