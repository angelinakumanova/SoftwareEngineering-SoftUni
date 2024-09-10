package Encapsulation.Exercises.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if ("END".equals(input)) {
                break;
            }

            String[] tokens = input.split(";");
            String command = tokens[0];
            try {
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                        break;
                    case "Add":
                        addPlayer(tokens, teams);
                        break;
                    case "Remove":
                        removePlayer(tokens, teams);
                        break;
                    case "Rating":
                        printRating(tokens, teams);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addPlayer(String[] tokens, Map<String, Team> teams) {
        String teamName = tokens[1];

        if (teams.containsKey(teamName)) {
            String playerName = tokens[2];
            int endurance = Integer.parseInt(tokens[3]);
            int sprint = Integer.parseInt(tokens[4]);
            int dribble = Integer.parseInt(tokens[5]);
            int passing = Integer.parseInt(tokens[6]);
            int shooting = Integer.parseInt(tokens[7]);

            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
            teams.get(teamName).addPlayer(player);
        } else {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
    }

    private static void removePlayer(String[] tokens, Map<String, Team> teams) {
        String teamName = tokens[1];
        String playerName = tokens[2];

        teams.get(teamName).removePlayer(playerName);
    }

    private static void printRating(String[] tokens, Map<String, Team> teams) {
        String teamName = tokens[1];
        if (!teams.containsKey(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
        }
    }
}
