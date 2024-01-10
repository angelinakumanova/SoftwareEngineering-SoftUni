package ExamProblems.FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VFinalExam_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern digitsPattern = Pattern.compile("\\d");
        Matcher digitsMatcher = digitsPattern.matcher(input);

        long coolThreshold = 1;
        while (digitsMatcher.find()) {
            coolThreshold *= Integer.parseInt(digitsMatcher.group());
        }

        Pattern validPattern = Pattern.compile("(\\*\\*|::)(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher validMatcher = validPattern.matcher(input);

        List<String> coolEmojis = new ArrayList<>();
        int count = 0;
        while (validMatcher.find()) {
            int sumOfEmoji = 0;
            for (int i = 0; i < validMatcher.group("emoji").length(); i++) {
                char ch = validMatcher.group("emoji").charAt(i);
                sumOfEmoji += ch;
            }

            if (sumOfEmoji >= coolThreshold) {
                coolEmojis.add(validMatcher.group());
            }
            count++;
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(count + " emojis found in the text. The cool ones are:");
        for (String emoji : coolEmojis) {
            System.out.println(emoji);
        }


    }
}
