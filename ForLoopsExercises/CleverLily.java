package ForLoopsExercises;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ageOfLily = Integer.parseInt(scanner.nextLine());
        double priceOfWashingMachine = Double.parseDouble(scanner.nextLine());
        int priceOfToy = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        int toy = 0;

        for (int i = 1; i <= ageOfLily; i++) {
            if (i % 2 == 0) {
                sum += 10 * (i / 2.0) - 1;
            } else {
                toy++;
            }
        } sum += toy * priceOfToy;
        if (sum >= priceOfWashingMachine) {
            sum -= priceOfWashingMachine;
            System.out.printf("Yes! %.2f", sum);
        } else {
            sum = priceOfWashingMachine - sum;
            System.out.printf("No! %.2f", sum);
        }
    }
}
