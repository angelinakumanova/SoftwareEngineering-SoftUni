package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern healthPattern = Pattern.compile("[^0-9\\+\\-\\*\\/\\.]");
        String[] inputs = scanner.nextLine().split("\\s*,\\s*");

        for (int i = 0; i < inputs.length; i++) {
            Matcher healthMatcher = healthPattern.matcher(inputs[i]);
            int health = 0;
            while (healthMatcher.find()) {
                health += healthMatcher.group().charAt(0);
            }

            Pattern damagePattern = Pattern.compile("[-+]?[0-9.]+");
            Matcher damageMatcher = damagePattern.matcher(inputs[i]);
            double damage = 0;
            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            Pattern pattern = Pattern.compile("[*/]");
            Matcher matcher = pattern.matcher(inputs[i]);

            while (matcher.find()) {
                if (matcher.group().equals("*")) {
                    damage *= 2;
                } else if (matcher.group().equals("/")) {
                    damage /= 2;
                }

            }

            System.out.printf("%s - %d health, %.2f damage%n", inputs[i], health, damage);
        }
    }
}
