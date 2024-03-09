package Polymorphism.Exercises.VehiclesExtension;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        VehicleImpl car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        VehicleImpl truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        VehicleImpl bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, VehicleImpl> vehicles = Map.of("Car", car, "Truck", truck, "Bus", bus);
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            try {
                switch (command) {
                    case "Drive":
                        VehicleImpl vehicle = vehicles.get(tokens[1]);
                        if (vehicle instanceof Bus) {
                            bus.setEmpty(false);
                        }
                        vehicle.drive(Double.parseDouble(tokens[2]));
                        break;
                    case "DriveEmpty":
                        bus.setEmpty(true);
                        vehicles.get("Bus").drive(Double.parseDouble(tokens[2]));
                        break;
                    case "Refuel":
                        vehicles.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
