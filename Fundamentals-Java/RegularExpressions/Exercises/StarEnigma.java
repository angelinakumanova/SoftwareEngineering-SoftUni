package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern counter = Pattern.compile("[starSTAR]");
        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcherCount = counter.matcher(input);

            int count = 0;
            while (matcherCount.find()) {
                count++;
            }

            char[] inputChars = input.toCharArray();
            String message = "";
            for (int position = 0; position < inputChars.length; position++) {
                char newCh = (char) (inputChars[position] - count);
                message += newCh;
            }

            Pattern pattern = Pattern.compile("[^@\\-!:>]*?@(?<name>[A-Za-z]+)[^@\\-!:>]*?:[^@\\-!:>]*?\\d+[^@\\-!:>]*?![^@\\-!:>]*?(?<attack>[A|D])[^@\\-!:>]*?![^@\\-!:>]*?->\\d+");
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                if (matcher.group("attack").equals("A")) {
                    attackedPlanets.add(matcher.group("name"));
                } else if (matcher.group("attack").equals("D")) {
                    destroyedPlanets.add(matcher.group("name"));
                }
            }

        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        for (String planet : attackedPlanets) {
            System.out.println("-> " + planet);
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        for (String planet : destroyedPlanets) {
            System.out.println("-> " + planet);
        }
    }
}
