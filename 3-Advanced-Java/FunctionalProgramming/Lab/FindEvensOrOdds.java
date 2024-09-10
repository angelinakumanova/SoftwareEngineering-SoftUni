package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = reader.readLine();

        Function<String, IntPredicate> oddEvenFilter = s -> s.equals("odd") ?
                n -> n % 2 != 0 :
                n -> n % 2 == 0;

        IntConsumer printNumbers = n -> System.out.print(n + " ");

        IntStream.range(bounds[0], bounds[1] + 1)
                .filter(oddEvenFilter.apply(input))
                .forEach(printNumbers);
    }
}
