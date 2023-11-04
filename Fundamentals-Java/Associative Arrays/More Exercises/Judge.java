package AssociativeArrays.MoreExercises;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> contestsInfo = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> usersTotal = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);
            LinkedHashMap<String, Integer> users = new LinkedHashMap<>();
            users.put(username, points);

            if (!contestsInfo.containsKey(contest) ) {
                contestsInfo.put(contest, users);
                if (usersTotal.containsKey(username)) {
                    usersTotal.put(username, usersTotal.get(username) + points);
                } else {
                    usersTotal.put(username, points);
                }
            } else {
                if (!contestsInfo.get(contest).containsKey(username)) {
                    contestsInfo.get(contest).put(username, points);
                    if (usersTotal.containsKey(username)) {
                        usersTotal.put(username, usersTotal.get(username) + points);
                    } else {
                        usersTotal.put(username, points);
                    }

                } else {
                    if (contestsInfo.get(contest).get(username) < points) {
                        contestsInfo.get(contest).put(username, points);
                        usersTotal.put(username, usersTotal.get(username) + Math.abs(usersTotal.get(username) - points));
                    }
                }
            }
            input = scanner.nextLine();
        }

        AtomicInteger number = new AtomicInteger();
        contestsInfo.forEach((key, value) -> {
            number.set(0);
            System.out.printf("%s: %d participants%n", key, value.size());
            value.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                    .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(element -> System.out.printf("%d. %s <::> %d%n",
                            number.incrementAndGet(),
                            element.getKey(),
                            element.getValue()));
        });


        System.out.println("Individual standings:");
            number.set(0);
            usersTotal.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(element -> System.out.printf("%d. %s -> %d%n",
                            number.incrementAndGet(),
                            element.getKey(),
                            element.getValue()));
    }
}

