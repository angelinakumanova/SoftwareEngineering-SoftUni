package SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((num1, num2) -> num2.compareTo(num1))
                .collect(Collectors.toList());

        for (int i = 0; i < (sortedList.size() >= 4 ? 3 : sortedList.size()); i++) {
            System.out.print(sortedList.get(i) + " ");
        }
    }
}
