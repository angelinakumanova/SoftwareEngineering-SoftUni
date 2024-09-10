package DefiningClasses.Exercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostFor1km = Double.parseDouble(tokens[2]);

            cars.putIfAbsent(model, new Car(model, fuelAmount, fuelCostFor1km));
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String model = command.split("\\s+")[1];
            int distanceToTravel = Integer.parseInt(command.split("\\s+")[2]);
            cars.get(model).drive(distanceToTravel);

            command = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
