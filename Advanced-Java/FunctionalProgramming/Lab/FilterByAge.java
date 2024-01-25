package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] person = reader.readLine().split(",\\s+");
            people.put(person[0], Integer.parseInt(person[1]));
        }
        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        BiFunction<Integer, String, Predicate<Integer>> predicateFactory = (a, c) -> {
            if ("younger".equals(c)) {
                return x -> x <= a;
            }
            return x -> x >= a;
        };

        Function<String, Consumer<Map.Entry<String, Integer>>> consumerFactory = a -> {
            switch (a) {
                case "name":
                    return m -> System.out.println(m.getKey());
                case "age":
                    return m -> System.out.println(m.getValue());
                default:
                    return m -> System.out.println(m.getKey() + " - " + m.getValue());
            }
        };

        people.entrySet().stream()
                .filter(e -> predicateFactory.apply(age, condition).test(e.getValue()))
                .forEach(e -> consumerFactory.apply(format).accept(e));
    }
}
