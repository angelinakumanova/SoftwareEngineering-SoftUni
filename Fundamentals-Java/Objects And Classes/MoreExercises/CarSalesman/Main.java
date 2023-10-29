package ObjectsAndClasses.MoreExercises.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String engineInfo = scanner.nextLine();
            String[] infoParts = engineInfo.split(" ");
            Engine engine = new Engine(infoParts[0], infoParts[1]);
            if (infoParts.length >= 3) {
                if (infoParts.length == 3) {
                    if (checkIfItIsNumber(infoParts[2])) {
                        engine.setDisplacement(infoParts[2]);
                    } else {
                        engine.setEfficiency(infoParts[2]);
                    }
                } else {
                    engine.setDisplacement(infoParts[2]);
                    engine.setEfficiency(infoParts[3]);
                }
            }
            engines.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String carInfo = scanner.nextLine();
            String[] infoParts = carInfo.split(" ");
            Car car = new Car(infoParts[0]);
            for (Engine engine : engines) {
                if (infoParts[1].equals(engine.getModel())) {
                    car.setEngine(engine);
                    break;
                }
            }

            if (infoParts.length >= 3) {
                if (infoParts.length == 3) {
                    if (checkIfItIsNumber(infoParts[2])) {
                        car.setWeight(infoParts[2]);
                    } else {
                        car.setColor(infoParts[2]);
                    }
                } else {
                    car.setWeight(infoParts[2]);
                    car.setColor(infoParts[3]);
                }
            }
            cars.add(car);
        }

        System.out.println(cars.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "")
                .trim());
    }

    public static boolean checkIfItIsNumber (String info) {
        for (int i = 0; i < info.length(); i++) {
            if (info.charAt(i) >= 48 && info.charAt(i) <= 57) {
                return true;
            }
        }
        return false;
    }
}
