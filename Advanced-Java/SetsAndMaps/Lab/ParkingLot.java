package SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> cars = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(",\\s+");
            if (tokens[0].equals("IN")) {
                cars.add(tokens[1]);
            } else if (tokens[0].equals("OUT")) {
                cars.remove(tokens[1]);
            }

            input = scanner.nextLine();
        }


        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String car : cars) {
            System.out.println(car);
        }
    }
}
