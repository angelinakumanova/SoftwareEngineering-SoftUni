package AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Character, Integer> charsCount = new LinkedHashMap<>();

        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!charsCount.containsKey(word.charAt(i))) {
                    charsCount.put(word.charAt(i), 1);
                } else {
                    charsCount.put(word.charAt(i), charsCount.get(word.charAt(i)) + 1);
                }
            }
        }

        for(Map.Entry<Character, Integer> entry : charsCount.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
