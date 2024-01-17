package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"search".equals(input)) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            contacts.put(name, number);

            input = scanner.nextLine();
        }


        String secondInput = scanner.nextLine();
        while (!"stop".equals(secondInput)) {
            if (!contacts.containsKey(secondInput)) {
                System.out.printf("Contact %s does not exist.%n", secondInput);
            } else {
                System.out.printf("%s -> %s%n", secondInput, contacts.get(secondInput));
            }
            secondInput = scanner.nextLine();
        }
    }
}
