package DefiningClasses.Exercises.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nEngines = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < nEngines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String power = tokens[1];
            if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engines.put(model, new Engine(model, power, displacement));
                } else {
                    String efficiency = tokens[2];
                    engines.put(model, new Engine(model, power, efficiency));
                }
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engines.put(model, new Engine(model, power, displacement, efficiency));
            } else {
                engines.put(model, new Engine(model, power));
            }
        }

        int nCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engines.get(tokens[1]);

            if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    int weight = Integer.parseInt(tokens[2]);
                    cars.add(new Car(model, engine, weight));
                } else {
                    String color = tokens[2];
                    cars.add(new Car(model, engine, color));
                }
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                cars.add(new Car(model, engine, weight, color));
            } else {
                cars.add(new Car(model, engine));
            }
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
