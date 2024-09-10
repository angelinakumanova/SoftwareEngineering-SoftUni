package AssociativeArrays.Exercises;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> users = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String side = input.split(" \\| ")[0];
                String user = input.split(" \\| ")[1];

                if (!users.containsKey(side)) {
                    users.put(side, new ArrayList<>());
                }
                if (!userExists(users, user)) {
                    users.get(side).add(user);
                }
            } else if (input.contains("->")) {
                String user = input.split(" -> ")[0];
                String side = input.split(" -> ")[1];

                if(userExists(users, user) && users.containsKey(side)) {
                    removeUser(users, user);
                    users.get(side).add(user);
                } else if (!userExists(users, user) && users.containsKey(side)) {
                    users.get(side).add(user);
                } else if (!userExists(users, user) && !users.containsKey(side)){
                    users.put(side, new ArrayList<>());
                    users.get(side).add(user);
                } else {
                    removeUser(users, user);
                    users.put(side, new ArrayList<>());
                    users.get(side).add(user);
                }

                System.out.printf("%s joins the %s side!%n", user, side);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            if (entry.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.printf("! %s%n", entry.getValue().get(i));
                }
            }
        }
    }

    public static boolean userExists (LinkedHashMap<String, List<String>> users, String user) {
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).equals(user)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void removeUser (LinkedHashMap<String, List<String>> users, String user) {
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).equals(user)) {
                   entry.getValue().remove(user);
                   return;
                }
            }
        }
    }
}
