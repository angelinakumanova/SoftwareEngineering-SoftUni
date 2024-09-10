package ObjectsAndClasses.MoreExercises.TeamWorkProjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTeams = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();

        for (int i = 1; i <= numberOfTeams ; i++) {
            String teamInfo = scanner.nextLine();
            String user = teamInfo.split("-")[0];
            String teamName = teamInfo.split("-")[1];
            if (!teamExists(teams, teamName)) {
                if (!userHasATeam(teams, user)) {
                    Team team = new Team(user, teamName);
                    teams.add(team);
                    System.out.printf("Team %s has been created by %s!%n", teamName, user);
                } else {
                    System.out.printf("%s cannot create another team!%n", user);
                }
            } else {
                System.out.printf("Team %s was already created!%n", teamName);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String user = input.split("->")[0];
            String teamName = input.split("->")[1];

            if (!teamExists(teams, teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else if (userHasATeam(teams, user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
            } else {
                for (Team team : teams) {
                    if (team.getNameOfTeam().equals(teamName)) {
                        team.addMembers(user);
                    }
                }
            }
            input = scanner.nextLine();
        }

        Collections.sort(teams, Comparator.comparingInt(Team::membersCount).reversed().thenComparing(Team::getNameOfTeam));
        List<Team> teamsToDisband = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getMembers().size() == 0) {
                teamsToDisband.add(teams.get(i));
                teams.remove(teams.get(i));
                i = -1;
            }

        }
        printTeam(teams);
        printDisbandedTeams(teamsToDisband);

    }

    public static boolean teamExists (List<Team> teams, String teamName) {
        for (Team team : teams) {
            if (team.getNameOfTeam().equals(teamName)) {
                return true;
            }
        }

        return false;
    }

    public static boolean userHasATeam (List<Team> teams, String user) {
        for (Team team : teams) {
            if (team.getUser().equals(user)) {
                return true;
            }
            for (int i = 0; i < team.getMembers().size(); i++) {
                if (team.getMembers().get(i).equals(user)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printTeam (List<Team> teams) {
        for (Team team : teams) {
            System.out.println(team.getNameOfTeam());
            System.out.println("- " + team.getUser());
            Collections.sort(team.getMembers());
            for (int i = 0; i < team.getMembers().size(); i++) {
                System.out.println("-- " + team.getMembers().get(i));
            }
        }
    }

    public static void printDisbandedTeams (List<Team> teamsToDisband) {
        System.out.println("Teams to disband:");
        for (Team team : teamsToDisband) {
            System.out.println(team.getNameOfTeam());
        }
    }
}
