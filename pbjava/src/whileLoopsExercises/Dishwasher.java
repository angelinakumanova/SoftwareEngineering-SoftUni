package whileLoopsExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottles = Integer.parseInt(scanner.nextLine());
        int totalDetergent = bottles * 750;
        int dishesCounter = 0;
        int totalPots = 0;
        int totalDishes = 0;

        while (totalDetergent >= 0) {
            String input = scanner.nextLine();
            if ("End".equals(input)) {
                break;
            }
            dishesCounter++;
            if (dishesCounter % 3 == 0) {
                int pots = Integer.parseInt(input);
                totalPots += pots;
                pots *= 15;
                totalDetergent -= pots;
            } else {
                int dishes = Integer.parseInt(input);
                totalDishes += dishes;
                dishes *= 5;
                totalDetergent -= dishes;
            }
        }
        if (totalDetergent < 0) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(totalDetergent));
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", totalDishes, totalPots);
            System.out.printf("Leftover detergent %d ml.", totalDetergent);
        }
    }
}
