package SetsAndMaps.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] symbols = scanner.nextLine().toCharArray();
        Map<Character, Integer> occurrencesOfChars = new TreeMap<>();

        for (int i = 0; i < symbols.length; i++) {
            if (!occurrencesOfChars.containsKey(symbols[i])) {
                occurrencesOfChars.put(symbols[i], 1);
            } else {
                occurrencesOfChars.put(symbols[i], occurrencesOfChars.get(symbols[i]) + 1);
            }
        }

        for (Map.Entry<Character, Integer> occurrence : occurrencesOfChars.entrySet()) {
            System.out.printf("%c: %d time/s%n", occurrence.getKey(), occurrence.getValue());
        }
    }
}
