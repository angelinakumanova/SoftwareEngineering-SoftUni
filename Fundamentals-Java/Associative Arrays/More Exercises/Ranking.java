package AssociativeArrays.MoreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contestsInfo = new LinkedHashMap<>();
        TreeMap<String, HashMap<String, Integer>> candidatesInfo = new TreeMap<>();

        String firstInput = scanner.nextLine();
        while (!firstInput.equals("end of contests")) {
            String contest = firstInput.split(":")[0];
            String password = firstInput.split(":")[1];
            if (!contestsInfo.containsKey(contest)) {
                contestsInfo.put(contest, password);
            } else {
                contestsInfo.put(contest, password);
            }

            firstInput = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();
        while (!secondInput.equals("end of submissions")) {
            String[] tokens = secondInput.split("=>");
            String contest = tokens[0];
            if (contestsInfo.containsKey(contest)) {
                String password = tokens[1];

                if (contestsInfo.get(contest).equals(password)) {
                    String username = tokens[2];
                    HashMap<String, Integer> course = new HashMap<>();
                    int points = Integer.parseInt(tokens[3]);
                    course.put(contest, points);

                    if (!candidatesInfo.containsKey(username)) {
                        candidatesInfo.put(username, course);
                    } else {
                        if (!candidatesInfo.get(username).containsKey(contest)) {
                            candidatesInfo.get(username).put(contest, points);
                        } else {
                            candidatesInfo.get(username).put(contest,
                                    Math.max(points, candidatesInfo.get(username).get(contest)));
                        }
                    }
                }
            }

            secondInput = scanner.nextLine();
        }

        int bestSum = 0;
        String bestCandidate = "";
        for (Map.Entry<String, HashMap<String, Integer>> entry : candidatesInfo.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > bestSum) {
                bestSum = sum;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestSum);



        System.out.println("Ranking: ");
        for (Map.Entry<String, HashMap<String, Integer>> entry : candidatesInfo.entrySet()) {
            System.out.println(entry.getKey());

            LinkedHashMap<String, Integer> sortedResult = new LinkedHashMap<>();
            List<Integer> values = new ArrayList<>();
            for (Map.Entry<String, Integer> contest : entry.getValue().entrySet()) {
                values.add(contest.getValue());
            }
            Collections.sort(values);
            for (int i = values.size() - 1; i >= 0 ; i--) {
                for (Map.Entry<String, Integer> contest : entry.getValue().entrySet()) {
                    if (contest.getValue().equals(values.get(i))) {
                        sortedResult.put(contest.getKey(), values.get(i));
                    }
                }
            }

            for (Map.Entry<String, Integer> result : sortedResult.entrySet()) {
                System.out.printf("#  %s -> %d%n", result.getKey(), result.getValue());
            }

        }
    }
}
