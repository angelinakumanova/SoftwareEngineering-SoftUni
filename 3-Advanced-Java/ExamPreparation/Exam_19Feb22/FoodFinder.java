package ExamPreparation.Exam_19Feb22;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(v -> vowels.offer(v.charAt(0)));

        Deque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(c -> consonants.push(c.charAt(0)));

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        while (!consonants.isEmpty()) {
            char currVowel = vowels.peek();
            char currConsonant = consonants.peek();

            for (int i = 0; i < words.length; i++) {
                String currWord = words[i];
                int vowelIdx = currWord.indexOf(currVowel);
                int consonantIdx = currWord.indexOf(currConsonant);

                if (vowelIdx != -1) {
                    foundWords[i] = foundWords[i].substring(0, vowelIdx) + currVowel +
                            foundWords[i].substring(vowelIdx + 1);
                }
                if (consonantIdx != -1) {
                    foundWords[i] = foundWords[i].substring(0, consonantIdx) + currConsonant +
                            foundWords[i].substring(consonantIdx + 1);
                }

            }

            vowels.offerLast(vowels.poll());
            consonants.pop();
        }

        String[] array = Arrays.stream(foundWords).filter(w -> !w.contains("*")).toArray(String[]::new);
        System.out.println("Words found: " + array.length);
        Arrays.stream(array).forEach(System.out::println);
    }
}
