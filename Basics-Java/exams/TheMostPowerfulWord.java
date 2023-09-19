package exams;

import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0;
        double maxSum = 0;
        String winnerWord = "";


        while (!"End of words".equals(input)) {

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                sum += symbol;

            }
                for (int j = input.length(); j < input.length() + 1; j++) {
                    char symbol = input.charAt(0);
                    boolean firstLetter = symbol == 'a' || symbol == 'A' || symbol == 'e' || symbol == 'E' ||
                            symbol == 'i' || symbol == 'I' || symbol == 'o' || symbol == 'O' ||
                            symbol == 'u' ||  symbol == 'U' || symbol == 'y' || symbol == 'Y';
                    if (firstLetter) {
                        sum *= input.length();
                    } else {
                        sum /= input.length();
                        sum = Math.floor(sum);
                    }
                    if (sum > maxSum) {
                        winnerWord = input;
                        maxSum = sum;
                    }

                }

            input = scanner.nextLine();
                sum = 0;
        }
        System.out.printf("The most powerful word is %s - %.0f", winnerWord, maxSum);
    }
}
