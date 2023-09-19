package ForLoopsExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());
        double totalElectricity = 0;
        double totalWater = 20 * months;
        double totalInternet = 15 * months;


        for (int i = 1; i <= months; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());
            totalElectricity += electricityBill;
        }
        double othersSum = (totalInternet + totalWater + totalElectricity) * 20.0 / 100 + (totalInternet + totalWater + totalElectricity);
        System.out.printf("Electricity: %.2f lv%n", totalElectricity);
        System.out.printf("Water: %.2f lv%n", totalWater);
        System.out.printf("Internet: %.2f lv%n", totalInternet);
        System.out.printf("Other: %.2f lv%n", othersSum);
        System.out.printf("Average: %.2f lv", (othersSum + totalInternet + totalWater + totalElectricity) / months);
    }
}
