package AlgorithmsWorkShop;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        mergeSort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int halfIdx = array.length / 2;

        int[] firstPart = new int[halfIdx];
        int[] secondPart = new int[array.length - halfIdx];

        for (int i = 0; i < halfIdx; i++) {
            firstPart[i] = array[i];
        }
        for (int i = halfIdx; i < array.length; i++) {
            secondPart[i - halfIdx] = array[i];
        }

        firstPart = mergeSort(firstPart);
        secondPart = mergeSort(secondPart);

        int mainIndex = 0;
        int firstPartIdx = 0;
        int secondPartIdx = 0;

        while (firstPartIdx < firstPart.length && secondPartIdx < secondPart.length) {
            if (firstPart[firstPartIdx] < secondPart[secondPartIdx]) {
                array[mainIndex] = firstPart[firstPartIdx];

                mainIndex++;
                firstPartIdx++;
            } else {
                array[mainIndex] = secondPart[secondPartIdx];

                mainIndex++;
                secondPartIdx++;
            }
        }

        while (firstPartIdx < firstPart.length) {
            array[mainIndex] = firstPart[firstPartIdx];

            mainIndex++;
            firstPartIdx++;
        }
        while (secondPartIdx < secondPart.length) {
            array[mainIndex] = secondPart[secondPartIdx];

            mainIndex++;
            secondPartIdx++;
        }

        return array;
    }
}
