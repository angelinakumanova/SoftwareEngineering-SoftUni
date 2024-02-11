package ExamPreparation;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQuantity = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(milkQuantity::offer);

        Deque<Double> cacaoPowderQuantity = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoPowderQuantity::push);

        Map<String, Integer> chocolates = new TreeMap<>();
        while (!milkQuantity.isEmpty() && !cacaoPowderQuantity.isEmpty()) {
            double currentMilk = milkQuantity.peek();
            double currentCacaoPowder = cacaoPowderQuantity.peek();
            double cacaoPercentage = (currentCacaoPowder / (currentMilk + currentCacaoPowder)) * 100;

            if (cacaoPercentage == 30) {
                makeChocolate("Milk Chocolate", chocolates, milkQuantity, cacaoPowderQuantity);
            } else if (cacaoPercentage == 50) {
                makeChocolate("Dark Chocolate", chocolates, milkQuantity, cacaoPowderQuantity);
            } else if (cacaoPercentage == 100) {
                makeChocolate("Baking Chocolate", chocolates, milkQuantity, cacaoPowderQuantity);
            } else {
                cacaoPowderQuantity.pop();
                milkQuantity.offerLast(milkQuantity.poll() + 10);
            }

        }

        System.out.println(chocolates.size() == 3 ? "It’s a Chocolate Time. All chocolate types are prepared." :
                "Sorry, but you didn't succeed to prepare all types of chocolates.");
        chocolates.entrySet().forEach((e) -> System.out.printf("# %s --> %d%n", e.getKey(), e.getValue()));
    }

    private static void makeChocolate(String name, Map<String, Integer> chocolates,
                                      Deque<Double> milk, Deque<Double> cacaoPowder) {
        if (!chocolates.containsKey(name)) {
            chocolates.put(name, 1);
        } else {
            chocolates.put(name, chocolates.get(name) + 1);
        }

        milk.poll();
        cacaoPowder.pop();
    }
}
