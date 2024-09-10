package ExamPreparation.Exam_22Oct22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(milligramsOfCaffeine::push);

        Deque<Integer> energyDrinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int drankCaffeine = 0;
        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int currentCaffeine = milligramsOfCaffeine.peek();
            int currentEnergyDrink = energyDrinks.peek();
            int total = currentCaffeine * currentEnergyDrink;

            if (drankCaffeine + total <= 300) {
                drankCaffeine += total;
                milligramsOfCaffeine.pop();
                energyDrinks.poll();
            } else {
                milligramsOfCaffeine.pop();
                energyDrinks.offerLast(energyDrinks.poll());
                if (drankCaffeine >= 30) {
                    drankCaffeine -= 30;
                }
            }
        }

        System.out.println(!energyDrinks.isEmpty() ?
                String.format("Drinks left: %s", energyDrinks.toString().replaceAll("[]\\[]", ""))
                : "At least Stamat wasn't exceeding the maximum caffeine.");
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", drankCaffeine);
    }
}
