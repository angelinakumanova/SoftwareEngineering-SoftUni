package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IIIFinalExam_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(([@#])(?<words>[A-Za-z]{3,}\\2\\2[A-Za-z]{3,})\\2)");
        Matcher matcher = pattern.matcher(input);

        List<String> foundPairs = new ArrayList<>();
        int countPairs = 0;
        if (!matcher.find()) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
            return;
        } else {
            matcher = pattern.matcher(input);
            while (matcher.find()) {
                String pair = matcher.group("words");
                String firstWord = pair.split("[@#]{2}")[0];
                String secondWord = pair.split("[@#]{2}")[1];
                StringBuilder secondWordReversed = new StringBuilder(pair.split("[@#]{2}")[1]);
                if (firstWord.equals(secondWordReversed.reverse().toString())) {
                    String result = firstWord + " <=> " + secondWord;
                    foundPairs.add(result);
                }


                countPairs++;
            }
        }

        System.out.printf("%d word pairs found!%n", countPairs);
        if (foundPairs.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.printf("%s%n", String.join(", ",  foundPairs));
        }

    }
}
