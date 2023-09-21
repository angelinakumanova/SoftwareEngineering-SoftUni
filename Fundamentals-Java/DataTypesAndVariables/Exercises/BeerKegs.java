package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double biggestKegVolume = 0;
        String biggestKeg = "";

        for (int i = 0; i < n ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volumeOfKeg = Math.PI * Math.pow(radius, 2) * height;

            if (volumeOfKeg > biggestKegVolume) {
                biggestKegVolume = volumeOfKeg;
                biggestKeg = model;
            }
        }
        System.out.println(biggestKeg);
    }
}
