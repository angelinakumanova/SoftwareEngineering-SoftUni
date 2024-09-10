package ForLoopsExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());
        int price = 0;
        int priceLorry = 0;
        int priceTrain = 0;
        double loadBus = 0;
        double loadLorry = 0;
        double loadTrain = 0;
        double sumBus = 0;
        double sumLorry = 0;
        double sumTrain = 0;
        int totalLoad = 0;

        int load = 0;
        for (int i = 1; i <= amount; i++) {
            load = Integer.parseInt(scanner.nextLine());
            totalLoad += load;
            if (load <= 3) {
                loadBus += load;
                price = 200 * load;
                sumBus += price;
            } else if (load <= 11) {
                loadLorry += load;
                priceLorry = 175 * load;
                sumLorry += priceLorry;
            } else {
                loadTrain += load;
                priceTrain = 120 * load;
                sumTrain += priceTrain;
            }

        }
        System.out.printf("%.2f%n", (sumBus + sumLorry + sumTrain) / totalLoad);
        System.out.printf("%.2f%%%n", loadBus/totalLoad * 100);
        System.out.printf("%.2f%%%n", loadLorry/totalLoad * 100);
        System.out.printf("%.2f%%%n", loadTrain/totalLoad * 100);
    }
}
