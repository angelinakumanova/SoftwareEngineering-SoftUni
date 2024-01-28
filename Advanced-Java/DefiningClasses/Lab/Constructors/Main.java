package DefiningClasses.Lab.Constructors;

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
            String brand = tokens[0];
            Car car = null;
            if (tokens.length == 1) {
                car = new Car(brand);
            } else {
                int horsePower = Integer.parseInt(tokens[2]);
                String model = tokens[1];
                car = new Car(brand, model, horsePower);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
