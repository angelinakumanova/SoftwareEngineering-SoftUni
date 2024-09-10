package Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstList = scanner.nextLine().split(" ");
        String[] secondList = scanner.nextLine().split(" ");
        List<String> finalList = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;
        boolean isFirstListTurn = true;

        while (firstIndex >= 0 && firstIndex < firstList.length && secondIndex >= 0 && secondIndex < secondList.length) {

            if(isFirstListTurn) {
                finalList.add(firstList[firstIndex]);
                firstIndex++;
                isFirstListTurn = false;
            } else {
                finalList.add(secondList[secondIndex]);
                secondIndex++;
                isFirstListTurn = true;
            }
        }

        for (int i = firstIndex; i < firstList.length; i++) {
            finalList.add(firstList[i]);
        }
        for (int i = secondIndex; i < secondList.length; i++) {
            finalList.add(secondList[i]);
        }

        for (String number : finalList) {
            System.out.print(number + " ");
        }
    }
}
