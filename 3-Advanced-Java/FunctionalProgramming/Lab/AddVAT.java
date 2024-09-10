package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(",\\s+");
        Function<String[], Double[]> doubleParser = n -> {
            Double[] prices = new Double[n.length];
            for (int i = 0; i < n.length; i++) {
                String s = n[i];
                prices[i] = Double.parseDouble(s);
            }

            return prices;
        };

        Double[] doubles = doubleParser.apply(data);

        UnaryOperator<Double[]> addVAT = n -> {
            for (int i = 0; i < n.length; i++) {
                n[i] = n[i] * 1.2;
            }
            return n;
        };

        addVAT.apply(doubles);

        Consumer<Double[]> printPrices = p -> {
            System.out.println("Prices with VAT:");
            for (Double price : doubles) {
                System.out.printf("%.2f%n", price);
            }
        };

        printPrices.accept(doubles);


    }
}
