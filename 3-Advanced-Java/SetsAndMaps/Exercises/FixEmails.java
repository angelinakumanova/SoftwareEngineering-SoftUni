package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> correctEmails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String email = scanner.nextLine();
            String domain = email.substring(email.lastIndexOf(".") + 1);

            if (!(domain.equalsIgnoreCase("uk") || domain.equalsIgnoreCase("us") ||
                domain.equalsIgnoreCase("com"))) {
                correctEmails.put(input, email);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : correctEmails.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
