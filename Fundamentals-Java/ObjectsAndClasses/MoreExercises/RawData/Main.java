package ObjectsAndClasses.MoreExercises.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Tire> tires = new ArrayList<>();
            String carInfo = scanner.nextLine();
            for (int j = 5; j <= 11; j++) {

                Tire tire = new Tire(Double.parseDouble(carInfo.split(" ")[j]),
                        Integer.parseInt(carInfo.split(" ")[j + 1]));
                tires.add(tire);
                j++;
            }
            Engine engine = new Engine(Integer.parseInt(carInfo.split(" ")[1]),
                    Integer.parseInt(carInfo.split(" ")[2]));
            Cargo cargo = new Cargo(Integer.parseInt(carInfo.split(" ")[3]), carInfo.split(" ")[4]);
            Car car = new Car(carInfo.split(" ")[0], engine, cargo, tires);
            cars.add(car);
        }

        String input = scanner.nextLine();
        if (input.equals("fragile")) {
            boolean tirePressureIsLessThanOne = false;
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equals("fragile")) {
                    for (Tire tire : car.getTires()) {
                        if (tire.getTirePressure() < 1) {
                            tirePressureIsLessThanOne = true;
                            break;
                        }
                    }
                    if (tirePressureIsLessThanOne) {
                        System.out.println(car.getModel());
                    }
                }
            }
        } else if (input.equals("flamable")) {
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equals("flamable")) {
                    if (car.getEngine().getEnginePower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }
}
