package SetsAndMaps.Exercises;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeSet<String>> users = new TreeMap<>();
        Map<String, Integer> usersDuration = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[1];
            String IP = tokens[0];
            int duration = Integer.parseInt(tokens[2]);

            if (!users.containsKey(name)) {
                users.put(name, new TreeSet<>());
                users.get(name).add(IP);
                usersDuration.put(name, duration);
            } else {
                users.get(name).add(IP);
                usersDuration.put(name, usersDuration.get(name) + duration);
            }
        }

        for (Map.Entry<String, TreeSet<String>> user : users.entrySet()) {
            System.out.printf("%s: %d [%s]%n",
                    user.getKey(),
                    usersDuration.get(user.getKey()),
                    String.join(", ", user.getValue()));
        }
    }
}
