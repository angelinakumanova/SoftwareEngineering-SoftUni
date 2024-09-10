package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AddVAT_II {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> addVAT = x -> x * 1.2;
        Double[] array = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Double::parseDouble)
                .map(addVAT)
                .toArray(Double[]::new);

        Consumer<Double[]> printPrices = p -> {
            System.out.println("Prices with VAT:");
            for (Double price : array) {
                System.out.printf("%.2f%n", price);
            }
        };
        printPrices.accept(array);
    }
}
