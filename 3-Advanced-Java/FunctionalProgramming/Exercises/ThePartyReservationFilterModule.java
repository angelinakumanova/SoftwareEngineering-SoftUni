package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> predicate;

        List<String> filters = new ArrayList<>();
        String line = scanner.nextLine();
        while (!"Print".equals(line)) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            String parameter = tokens[2];

            if (command.contains("Add")) {
                filters.add(filterType + ";" + parameter);
            } else {
                filters.remove(filterType + ";" + parameter);
            }

            line = scanner.nextLine();
        }

        List<Predicate<String>> predicates = new ArrayList<>();
        for (String filter : filters) {
            String command = filter.split(";")[0];
            String parameter = filter.split(";")[1];

            switch (command) {
                case "Starts with":
                    predicate = s -> !s.startsWith(parameter);
                    break;
                case "Ends with":
                    predicate = s -> !s.endsWith(parameter);
                    break;
                case "Length":
                    predicate = s -> s.length() != Integer.parseInt(parameter);
                    break;
                default:
                    predicate = s -> !s.contains(parameter);
            }
            predicates.add(predicate);
        }

        Predicate<String> combinedPredicate = predicates.stream().reduce(Predicate::and).orElse(x -> false);
        people.stream().filter(combinedPredicate).forEach(e -> System.out.print(e + " "));


    }
}
