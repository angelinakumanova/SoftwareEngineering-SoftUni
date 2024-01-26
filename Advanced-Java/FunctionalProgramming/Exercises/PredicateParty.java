package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> predicate;

        String line = scanner.nextLine();
        while (!"Party!".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String criteria = tokens[1];
            String parameter = tokens[2];

            switch (criteria) {
                case "StartsWith":
                    predicate = s -> s.startsWith(parameter);
                    break;
                case "EndsWith":
                    predicate = s -> s.endsWith(parameter);
                    break;
                default:
                    predicate = s -> s.length() == Integer.parseInt(parameter);
            }

            if (command.equals("Remove")) {
                people.removeIf(predicate);
            } else {
                List<String> peopleToAdd = people.stream().filter(predicate).collect(Collectors.toList());
                people.addAll(peopleToAdd);
            }

            line = scanner.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String result = people.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(result + " are going to the party!");

        }
    }
}
