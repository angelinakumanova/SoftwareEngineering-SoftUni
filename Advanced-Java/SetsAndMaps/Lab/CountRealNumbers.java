package SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();
        double[] numbersInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < numbersInput.length; i++) {
            if (!numbers.containsKey(numbersInput[i])) {
                numbers.put(numbersInput[i], 1);
            } else {
                numbers.put(numbersInput[i], numbers.get(numbersInput[i]) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
