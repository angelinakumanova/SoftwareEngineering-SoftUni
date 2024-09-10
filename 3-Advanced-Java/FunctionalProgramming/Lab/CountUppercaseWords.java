package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isUppercase = s -> Character.isUpperCase(s.charAt(0));

        List<String> uppercaseWords = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(isUppercase)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        for (String uppercaseWord : uppercaseWords) {
            System.out.println(uppercaseWord);
        }
    }
}
