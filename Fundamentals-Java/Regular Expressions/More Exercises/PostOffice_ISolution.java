package RegularExpressions.MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice_ISolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParts = scanner.nextLine().split("\\|");
        Pattern firstPartPattern = Pattern.compile("([#$%*&])([A-Z]+)(\\1)");
        Matcher firstPartMatcher = firstPartPattern.matcher(inputParts[0]);

        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();
        if (firstPartMatcher.find()) {
            if (firstPartMatcher.group(1).equals(firstPartMatcher.group(3))) {
                for (int i = 0; i < firstPartMatcher.group(2).length(); i++) {
                    words.put(String.valueOf(firstPartMatcher.group(2).charAt(i)), 0);
                }
            }
        }

        Pattern secondPartPattern = Pattern.compile("(?<ch>\\d{2}):(?<times>\\d{2})");
        Matcher secondPartMatcher = secondPartPattern.matcher(inputParts[1]);

        while (secondPartMatcher.find()) {
            for (int i = 0; i < words.size(); i++) {
                String ch = String.valueOf((char) Integer.parseInt(secondPartMatcher.group("ch")));
                if (words.containsKey(ch)) {
                    words.put(ch, Integer.parseInt(secondPartMatcher.group("times")) + 1);
                    break;
                }
            }
        }

        List<String> listOfWords = new ArrayList<>();
        listOfWords.addAll(List.of(inputParts[2].split(" ")));


        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            for (int i = 0; i < listOfWords.size(); i++) {
                if (entry.getValue() == listOfWords.get(i).length()
                        && String.valueOf(listOfWords.get(i).charAt(0)).equals(entry.getKey())) {
                        System.out.println(listOfWords.get(i));
                        break;
                }
            }
        }
    }
}
