package RegularExpressions.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();
        Pattern pattern = Pattern.compile("(?<str>[ -\\/:-~]+)(?<num>\\d+)");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();
        StringBuilder uniqueSymbols = new StringBuilder();
        while (matcher.find()) {
            if (!matcher.group("num").equals("0")) {
                uniqueSymbols.append(matcher.group("str"));
            }
            for (int i = 0; i < Integer.parseInt(matcher.group("num")); i++) {
                result.append(matcher.group("str"));
            }
        }
        List<Character> symbolsList = new ArrayList<>();
        for (int i = 0; i < uniqueSymbols.length(); i++) {
            if (!symbolsList.contains(uniqueSymbols.charAt(i))) {
                symbolsList.add(uniqueSymbols.charAt(i));
            }
        }
        System.out.printf("Unique symbols used: %d%n", symbolsList.size());
        System.out.println(result);
    }
}
