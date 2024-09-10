package SetsAndMaps.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> stores = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if ("Revision".equals(input)) {
                break;
            }

            String[] storeInfo = input.split(",\\s+");
            String storeName = storeInfo[0];
            String product = storeInfo[1];
            double price = Double.parseDouble(storeInfo[2]);


            if (!stores.containsKey(storeName)) {
                stores.put(storeName, new LinkedHashMap<>());
                stores.get(storeName).put(product, price);
            } else {
                stores.get(storeName).put(product, price);
            }
        }

        for (Map.Entry<String, Map<String, Double>> store : stores.entrySet()) {
            System.out.println(store.getKey() + "->");
            store.getValue().forEach((key, value) -> {
                System.out.printf("Product: %s, Price: %.1f%n", key, value);
            });
        }
    }
}
