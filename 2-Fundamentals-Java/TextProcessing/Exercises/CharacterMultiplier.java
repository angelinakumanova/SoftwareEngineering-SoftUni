package TextProcessing.Exercises;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        String str1 = strings[0];
        String str2 = strings[1];
        int sum = 0;
        if (str1.length() > str2.length()) {
            for (int i = 0; i < str2.length(); i++) {
                int currentSum = str1.charAt(i) * str2.charAt(i);
                sum += currentSum;
            }
            for (int i = str2.length(); i < str1.length(); i++) {
                sum += str1.charAt(i);
            }
        } else if (str2.length() > str1.length()) {
            for (int i = 0; i < str1.length(); i++) {
                int currentSum = str1.charAt(i) * str2.charAt(i);
                sum += currentSum;
            }
            for (int i = str1.length(); i < str2.length() ; i++) {
                sum += str2.charAt(i);
            }
        } else {
            for (int i = 0; i < str1.length(); i++) {
                int currentSum = str1.charAt(i) * str2.charAt(i);
                sum += currentSum;
            }
        }

        System.out.println(sum);
    }
}
