package TextProcessing.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = Arrays.stream(scanner.nextLine().split("[ \t]")).filter(e -> !e.equals(""))
                .toArray(String[]::new);

        double result = 0;
        for (int i = 0; i < inputs.length; i++) {
                String str = inputs[i];
                double number = Double.parseDouble(str.substring(1, str.length() - 1));


                for (int j = 0; j < str.length(); j++) {
                    if (j == 0) {
                        if (Character.isUpperCase(str.charAt(j))) {
                            number = number / (str.charAt(j) - 64);
                        } else if (Character.isLowerCase(str.charAt(j))) {
                            number = number * (str.charAt(j) - 96);
                        }
                    } else if (j == str.length() - 1) {
                        if (Character.isUpperCase(str.charAt(j))) {
                            number = number - (str.charAt(j) - 64);
                        } else if (Character.isLowerCase(str.charAt(j))) {
                            number = number + (str.charAt(j) - 96);
                        }
                    }
                }
                result += number;
        }

        System.out.printf("%.2f", result);
    }
}
