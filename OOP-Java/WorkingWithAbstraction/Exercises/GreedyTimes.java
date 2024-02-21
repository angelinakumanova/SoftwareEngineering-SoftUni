
package WorkingWithAbstraction.Exercises;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GreedyTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContent = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safeContent.length; i += 2) {
            String name = safeContent[i];
            long quantity = Long.parseLong(safeContent[i + 1]);
            long currentBagQuantity = bag.values().stream()
                    .map(Map::values).flatMap(Collection::stream)
                    .mapToLong(e -> e).sum() + quantity;

            String item = getItem(name);

            if (item.isEmpty() || currentBagQuantity > bagCapacity) {
                continue;
            }

            if (isValid(item, bag, quantity)) {
                bag.putIfAbsent(item, new LinkedHashMap<>());
                bag.get(item).putIfAbsent(name, 0L);

                addQuantity(bag, item, name, quantity, gold, gems, cash);
            }

        }

        printItems(bag);
    }

    private static String getItem(String name) {
        String item = "";

        if (name.length() == 3) {
            item = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            item = "Gold";
        }

        return item;
    }

    private static void addQuantity(Map<String, LinkedHashMap<String, Long>> bag, String item, String name,
                                    long quantity, long gold, long gems, long cash) {
        bag.get(item).put(name, bag.get(item).get(name) + quantity);
        if (item.equals("Gold")) {
            gold += quantity;
        } else if (item.equals("Gem")) {
            gems += quantity;
        } else if (item.equals("Cash")) {
            cash += quantity;
        }
    }

    private static void printItems(Map<String, LinkedHashMap<String, Long>> bag) {
        for (var items : bag.entrySet()) {
            Long sumValues = items.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", items.getKey(), sumValues);

            items.getValue().entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean isValid(String item, Map<String, LinkedHashMap<String, Long>> bag, long quantity) {
        boolean isValid = true;
        if (item.equals("Gem")) {
            if (!bag.containsKey(item)) {
                if (bag.containsKey("Gold")) {
                    if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        isValid = false;
                    }
                } else {
                    isValid = false;
                }
            } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + quantity >
                    bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                isValid = false;
            }
        } else if (item.equals("Cash")) {
            if (!bag.containsKey(item)) {
                if (bag.containsKey("Gem")) {
                    if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        isValid = false;
                    }
                } else {
                    isValid = false;
                }
            } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + quantity >
                    bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                isValid = false;
            }
        }

        return isValid;
    }
}