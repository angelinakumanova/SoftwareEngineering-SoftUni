package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int waterTankL = 255;
    int n = Integer.parseInt(scanner.nextLine());

    int sumLitres = 0;

        for (int i = 0; i < n; i++) {
            int litres = Integer.parseInt(scanner.nextLine());
            waterTankL -= litres;
            sumLitres += litres;
            if (waterTankL < 0) {
                System.out.println("Insufficient capacity!");
                waterTankL += litres;
                sumLitres -= litres;

            }
        }
        System.out.println(sumLitres);

    }
}
