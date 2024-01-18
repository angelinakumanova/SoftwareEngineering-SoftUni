package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String IP = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
                users.get(user).put(IP, 1);
            } else {
                if (!users.get(user).containsKey(IP)) {
                    users.get(user).put(IP, 1);
                } else {
                    users.get(user).put(IP, users.get(user).get(IP) + 1);
                }
            }

            input = scanner.nextLine();
        }

        for(Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            System.out.println(user.getKey() + ":");

            int count = 0;
            for (Map.Entry<String, Integer> IP : user.getValue().entrySet()) {
                if (count == user.getValue().size() - 1) {
                    System.out.printf("%s => %d.%n", IP.getKey(), IP.getValue());
                    break;
                }
                System.out.printf("%s => %d, ", IP.getKey(), IP.getValue());
                count++;
            }
        }
    }
}
