package DefiningClasses.Exercises.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType);

            int firstIdx = 5;
            int secondIdx = 6;
            for (int j = 0; j < 4; j++) {
                car.addTires(new Tire(Double.parseDouble(tokens[firstIdx]), Integer.parseInt(tokens[secondIdx])));
                firstIdx += 2;
                secondIdx += 2;
            }

            cars.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Car car : cars) {
                if (car.isFragileCar(car)) {
                    System.out.println(car);
                }
            }
        } else if (command.equals("flamable")) {
            for (Car car : cars) {
                if (car.isFlammableCar(car)) {
                    System.out.println(car);
                }
            }
        }
    }
}
