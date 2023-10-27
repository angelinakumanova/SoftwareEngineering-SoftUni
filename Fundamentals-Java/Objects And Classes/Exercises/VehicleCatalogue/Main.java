package ObjectsAndClasses.Exercises.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();

        while (!input.equals("End")) {
            String typeOfVehicle = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            if (typeOfVehicle.equalsIgnoreCase("car")) {
                Car car = new Car(model, color, horsepower);
                cars.add(car);
            } else if (typeOfVehicle.equalsIgnoreCase("truck")) {
                Truck truck = new Truck(model, color, horsepower);
                trucks.add(truck);
            }

            input = scanner.nextLine();
        }

        String modelInput = scanner.nextLine();

        while (!modelInput.equals("Close the Catalogue")) {
            if (isCar(cars, modelInput)) {
                printCarInfo(cars, modelInput);
            } else {
                printTruckInfo(trucks, modelInput);
            }

            modelInput = scanner.nextLine();
        }

        double averageHorsePowerCars = 0;
        double averageHorsePowerTrucks = 0;
        for (Car car : cars) {
            averageHorsePowerCars += car.getHorsepower();
        }
        for (Truck truck : trucks) {
            averageHorsePowerTrucks += truck.getHorsepower();
        }
        if (cars.size() != 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsePowerCars / cars.size());
        } else {
            System.out.println("Cars have average horsepower of: 0.00.");
        }
        if (trucks.size() != 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHorsePowerTrucks / trucks.size());
        } else {
            System.out.println("Trucks have average horsepower of: 0.00.");
        }

    }

    public static boolean isCar (List<Car> cars, String model) {

        for (Car car : cars) {
            if (model.equals(car.getModel())) {
                return true;
            }
        }

        return false;
    }

    public static void printCarInfo (List<Car> cars, String model) {
        for (Car car : cars) {
            if (model.equals(car.getModel())) {
                System.out.println("Type: Car");
                System.out.printf("Model: %s%n", car.getModel());
                System.out.printf("Color: %s%n", car.getColor());
                System.out.printf("Horsepower: %d%n", car.getHorsepower());
            }
        }
    }

    public static void printTruckInfo (List<Truck> trucks, String model) {
        for (Truck truck : trucks) {
            if (model.equals(truck.getModel())) {
                System.out.println("Type: Truck");
                System.out.printf("Model: %s%n", truck.getModel());
                System.out.printf("Color: %s%n", truck.getColor());
                System.out.printf("Horsepower: %d%n", truck.getHorsepower());
            }
        }
    }
}
