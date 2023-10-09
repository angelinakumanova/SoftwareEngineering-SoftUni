package Arrays.MoreExercises;

import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            String input = scanner.nextLine();
            for (int j = 0; j <= input.length(); j++) {
                if (j == input.length()) {
                    inputs[i] = sum;
                    break;
                }
                String letter = input.split("")[j];
                char chLetter = letter.charAt(0);
                if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e")
                || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")
                || letter.equalsIgnoreCase("i")) {
                    sum += ((int) chLetter * input.length());
                } else {
                    sum += ((int) chLetter / input.length());
                }
            }
        }


        for (int i = 0; i < inputs.length - 1; i++) {
            for (int j = i + 1; j < inputs.length; j++) {
               int temp = 0;
               if (inputs[i] > inputs[j]) {
                   temp = inputs [i];
                   inputs[i] = inputs[j];
                   inputs[j] = temp;
               }
            }

        }
        for (int input: inputs) {
            System.out.println(input + " ");
        }
    }
}
