package TextProcessing.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("find")) {
            String message = "";
            char[] symbols = input.toCharArray();
            int idx = 0;
            for (int i = 0; i < symbols.length; i++) {
                message += String.valueOf((char)(symbols[i] - key[idx]));
                idx++;
                if (idx == key.length) {
                    idx = 0;
                }
            }
            String typeOfTreasure = message.substring(message.indexOf("&") + 1, message.lastIndexOf("&"));
            String coordinates = message.substring(message.indexOf("<") + 1, message.indexOf(">"));
            System.out.printf("Found %s at %s%n", typeOfTreasure, coordinates);



            input = scanner.nextLine();
        }
    }
}
