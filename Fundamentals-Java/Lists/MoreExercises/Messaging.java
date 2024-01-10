package Lists.MoreExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> digits = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String text = scanner.nextLine();
        String result = "";

        for (int i = 0; i < digits.size(); i++) {
            int number = Integer.parseInt(digits.get(i));
            int sumOfDigits = 0;
            for (int j = 0; j < digits.get(i).length(); j++) {
                sumOfDigits += number % 10;
                number /= 10;
            }
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                char letter = text.charAt(j);

                if (count == sumOfDigits) {
                    result += letter;
                    StringBuilder string = new StringBuilder(text);
                    string.deleteCharAt(j);
                    text = String.valueOf(string);
                    break;
                }
                count++;
                if (j == text.length() - 1) {
                    j = -1;
                }
            }

        }
        System.out.println(result);
    }
}


