package RegularExpressions.MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split("\\s*,\\s*");

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].length() == 20) {
                String leftPart = inputs[i].substring(0, 10);
                String rightPart = inputs[i].substring(10);
                Pattern pattern = Pattern.compile("(\\@{6,}|\\${6,}|\\^{6,}|\\#{6,})");

                Matcher leftMatcher = pattern.matcher(leftPart);
                Matcher rightMatcher = pattern.matcher(rightPart);

                if (leftMatcher.find() && rightMatcher.find()) {
                    int min = Math.min(leftMatcher.group().length(), rightMatcher.group().length());
                        if (leftMatcher.group().substring(0, min).equals(rightMatcher.group().substring(0,min))) {
                            if (min == 10) {
                                System.out.printf("ticket \"%s\" - 10%s Jackpot!%n",
                                        inputs[i],
                                        leftMatcher.group().charAt(0));
                            } else {
                                System.out.printf("ticket \"%s\" - %d%s%n",
                                        inputs[i],
                                        min,
                                        leftMatcher.group().charAt(0));
                            }
                        } else {
                            System.out.printf("ticket \"%s\" - no match%n", inputs[i]);
                        }
                    } else {
                            System.out.printf("ticket \"%s\" - no match%n", inputs[i]);}
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
