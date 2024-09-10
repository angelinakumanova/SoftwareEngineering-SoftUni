package Lists.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String message = scanner.nextLine();
        List<String> numbers = new ArrayList<>();
        List<String> nonNumbers = new ArrayList<>();

        for (int i = 0; i < message.length(); i++) {
            char symbol = message.charAt(i);
            StringBuilder removeCharacters = new StringBuilder(message);
            if (symbol >= 48 && symbol <= 57) {
                numbers.add(String.valueOf(symbol));
            } else {
                nonNumbers.add(String.valueOf(symbol));
            }
            removeCharacters.deleteCharAt(i);
            message = String.valueOf(removeCharacters);

            i = -1;
        }

        List<String> takeList = new ArrayList<>();
        List<String> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }


        String result = "";
        String nonNumbersString = String.join("", nonNumbers);

        StringBuilder nonNumbersRemoveChars = new StringBuilder(nonNumbersString);
        for (int i = 0; i < takeList.size(); i++) {
            int takeIdx = Integer.parseInt(takeList.get(i));
            int takeCount = 0;

            if (nonNumbersString.length() > 0) {
                for (int j = 0; j < takeIdx; j++) {
                    char symbol = nonNumbersString.charAt(j);
                    result += symbol;
                    nonNumbersRemoveChars.deleteCharAt(j);
                    nonNumbersString = String.valueOf(nonNumbersRemoveChars);

                    takeCount++;
                    if (takeCount == takeIdx || nonNumbersString.length() == 0) {
                        break;
                    }
                    j = -1;
                }
            }

            int skipIdx = Integer.parseInt(skipList.get(i));
            int skipCount = 0;

            if (nonNumbersString.length() > 0) {
                for (int j = 0; j < skipIdx; j++) {
                    nonNumbersRemoveChars.deleteCharAt(j);
                    nonNumbersString = String.valueOf(nonNumbersRemoveChars);
                    skipCount++;

                    if (skipCount == skipIdx || nonNumbersString.length() == 0) {
                        break;
                    }
                    j = -1;
                }
            }

        }
        System.out.println(result);
    }
}
