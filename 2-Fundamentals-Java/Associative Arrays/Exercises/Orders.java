package AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Double> products = new LinkedHashMap<>();
        LinkedHashMap<String, Double> productsPrices = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String nameOfProduct = input.split(" ")[0];
            double priceOfProduct = Double.parseDouble(input.split(" ")[1]);
            double quantity = Double.parseDouble(input.split(" ")[2]);

            if (!productsPrices.containsKey(nameOfProduct)) {
                productsPrices.put(nameOfProduct, priceOfProduct);
            } else {
                productsPrices.put(nameOfProduct, priceOfProduct);
            }

            if (!products.containsKey(nameOfProduct)) {
                products.put(nameOfProduct, quantity);
            } else {
                products.put(nameOfProduct, products.get(nameOfProduct) + quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productsPrices.entrySet()) {
            products.put(entry.getKey(), entry.getValue() * products.get(entry.getKey()));
        }

        for(Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
