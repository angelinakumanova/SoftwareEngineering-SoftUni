package AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] tokens = input.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                LinkedHashMap<String, Integer> playerInfo = new LinkedHashMap<>();
                if (!players.containsKey(player)) {
                    playerInfo.put(position, skill);
                    players.put(player, playerInfo);
                } else {
                    if (!players.get(player).containsKey(position)) {
                        players.get(player).put(position, skill);
                    } else if (players.get(player).get(position) < skill) {
                        players.get(player).put(position, skill);
                    }
                }
             } else if (input.contains("vs")) {
                String[] tokens = input.split(" vs ");
                String firstPlayer = tokens[0];
                String secondPlayer = tokens[1];

                if (players.containsKey(firstPlayer) && players.containsKey(secondPlayer)) {
                    boolean hasCommon = false;
                    for (String p1 : players.get(firstPlayer).keySet()) {
                        for (String p2 : players.get(secondPlayer).keySet()) {
                            if (p1.equals(p2)) {
                                hasCommon = true;
                            }
                        }
                    }

                    if (hasCommon) {
                        if (players.get(firstPlayer).values().stream().mapToInt(i -> i).sum()
                                > players.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(secondPlayer);
                        } else if (players.get(firstPlayer).values().stream().mapToInt(i -> i).sum()
                                < players.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(firstPlayer);
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }
        LinkedHashMap<String, Integer> playersTotal = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> player : players.entrySet()) {
            int sum = player.getValue().values().stream().mapToInt(i -> i).sum();
            playersTotal.put(player.getKey(), sum);
        }

        playersTotal.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(element -> {
                    System.out.printf("%s: %d skill%n", element.getKey(), element.getValue());
                    for (Map.Entry<String, LinkedHashMap<String, Integer>> player : players.entrySet()) {
                        if (player.getKey().equals(element.getKey())) {
                            player.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                                            .reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                                    .forEach(e -> System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue()));
                        }
                    }
                });
    }

}
