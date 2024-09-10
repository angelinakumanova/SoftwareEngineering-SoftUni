package Lists.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();


        for (int i = 0; i < numberOfCommands ; i++) {
            String input = scanner.nextLine();
            String guest = input.split(" ")[0];
            if (input.contains("is going")) {
                if (!guests.contains(guest)) {
                    guests.add(guest);
                } else {
                    System.out.printf("%s is already in the list!%n", guest);
                }
            } else {
                if (!guests.contains(guest)) {
                    System.out.printf("%s is not in the list!%n", guest);
                } else {
                    guests.remove(guest);
                }
            }
        }

        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
