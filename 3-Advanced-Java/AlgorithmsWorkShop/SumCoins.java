package AlgorithmsWorkShop;

import java.util.*;
import java.util.stream.Collectors;

public class SumCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> allowedCoins = new LinkedHashMap<>();
        allowedCoins.put(50, 0);
        allowedCoins.put(20, 0);
        allowedCoins.put(10, 0);
        allowedCoins.put(5, 0);
        allowedCoins.put(2, 0);
        allowedCoins.put(1, 0);

        int[] coins = Arrays.stream(scanner.nextLine().replaceAll("\\D+", " ")
                        .trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int sum = Integer.parseInt(scanner.nextLine().split("Sum:\\s+")[1]);

        coins = sortArrayInReversed(coins);
        calcCoins(allowedCoins, coins, sum);

        Map<Integer, Integer> filtered = allowedCoins.entrySet().stream().filter(e -> e.getValue() > 0)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (filtered.isEmpty()) {
            System.out.println("Error");
        } else {
            int totalCoins = filtered.values().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.printf("Number of coins to take: %d%n", totalCoins);
            filtered.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByKey().reversed())
                    .forEach(e -> System.out.printf("%d coin(s) with value %d%n", e.getValue(), e.getKey()));
        }
    }

    private static Map<Integer, Integer> calcCoins(Map<Integer, Integer> allowedCoins, int[] coins, int sum) {
        for (int coin : coins) {
            if (allowedCoins.containsKey(coin)) {
                while (sum >= coin) {
                    sum -= coin;
                    allowedCoins.put(coin, allowedCoins.get(coin) + 1);
                }
            }
        }

        return allowedCoins;
    }

    private static int[] sortArrayInReversed(int[] coins) {
        int[] temp = new int[coins.length];
        int idx = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            temp[idx] = coins[i];
            idx++;
        }

        return temp;
    }
}
