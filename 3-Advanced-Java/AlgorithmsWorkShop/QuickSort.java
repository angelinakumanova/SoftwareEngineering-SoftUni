package AlgorithmsWorkShop;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(array);
        printArray(array);
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIdx = partition(array, low, high);

            quickSort(array, low, partitionIdx - 1);
            quickSort(array, partitionIdx + 1, high);
        }

    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                swap(array, i, j);
            }
        }
        swap(array,i + 1, high);

        return (i + 1);
    }

    private static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }
    private static void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

}
