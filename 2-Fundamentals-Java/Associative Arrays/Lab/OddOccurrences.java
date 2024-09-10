package AssociativeArrays.Lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();

        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            word = word.toLowerCase();
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }

        List<String> finalWords = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                finalWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", finalWords));
    }
}
