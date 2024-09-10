package AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> usernames = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languages = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];
            if (input.contains("banned")) {
                usernames.remove(username);
            } else {
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);

                if (!usernames.containsKey(username)) {
                    usernames.put(username, points);
                } else if (usernames.get(username) < points){
                    usernames.put(username, points);
                }
                if (!languages.containsKey(language)) {
                    languages.put(language, 1);
                } else {
                    languages.put(language, languages.get(language) + 1);
                }

            }

            input = scanner.nextLine();
        }
        System.out.println("Results: ");
        for (Map.Entry<String, Integer> entry : usernames.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions: ");
        for (Map.Entry<String, Integer> entry : languages.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
