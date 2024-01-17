package SetsAndMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String inputGuests = scanner.nextLine();
        while (!"PARTY".equals(inputGuests)) {
            guests.add(inputGuests);
            inputGuests = scanner.nextLine();
        }

        String guestsComing = scanner.nextLine();
        while (!"END".equals(guestsComing)) {
            guests.remove(guestsComing);

            guestsComing = scanner.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
