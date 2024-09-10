package Exams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IIIFinalExam_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> carsMileage = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> carsFuel = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            carsMileage.put(carInfo[0], Integer.parseInt(carInfo[1]));
            carsFuel.put(carInfo[0], Integer.parseInt(carInfo[2]));
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] tokens = command.split(" : ");
            if (tokens[0].equals("Drive")) {
                String car = tokens[1];
                int distance = Integer.parseInt(tokens[2]);
                int fuel = Integer.parseInt(tokens[3]);

                if (fuel > carsFuel.get(car)) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    carsFuel.put(car, carsFuel.get(car) - fuel);
                    carsMileage.put(car, carsMileage.get(car) + distance);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                            car,
                            distance,
                            fuel);
                    if (carsMileage.get(car) >= 100_000) {
                        System.out.printf("Time to sell the %s!%n", car);
                        carsFuel.remove(car);
                        carsMileage.remove(car);
                    }
                }
            } else if (tokens[0].equals("Refuel")) {
                String car = tokens[1];
                int fuel = Integer.parseInt(tokens[2]);

                int beforeRefuel = carsFuel.get(car);
                carsFuel.put(car, Math.min(75, carsFuel.get(car) + fuel));
                System.out.printf("%s refueled with %d liters%n", car, carsFuel.get(car) - beforeRefuel);
            } else if (tokens[0].equals("Revert")) {
                String car = tokens[1];
                int kilometres = Integer.parseInt(tokens[2]);

                if (carsMileage.get(car) - kilometres >= 10_000) {
                    carsMileage.put(car, carsMileage.get(car) - kilometres);
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometres);
                } else {
                    carsMileage.put(car, 10000);
                }
            }



            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> carMileage : carsMileage.entrySet()) {
            for (Map.Entry<String, Integer> carFuel : carsFuel.entrySet()) {
                if (carFuel.getKey().equals(carMileage.getKey())) {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                            carMileage.getKey(),
                            carMileage.getValue(),
                            carFuel.getValue());
                }
            }
        }
    }
}
