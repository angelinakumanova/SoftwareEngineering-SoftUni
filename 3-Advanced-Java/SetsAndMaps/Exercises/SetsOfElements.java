package SetsAndMaps.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengths = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(lengths[0]);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(lengths[1]);

        for (int i = 0; i < lengths[0]; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < lengths[1]; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int firstSetNums : firstSet) {
            for (int secondSetNums : secondSet) {
                if (firstSetNums == secondSetNums) {
                    System.out.print(secondSetNums + " ");
                }
            }
        }

    }
}
