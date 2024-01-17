package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = getPlayersNumbers(scanner);
        LinkedHashSet<Integer> secondPlayer = getPlayersNumbers(scanner);

        for (int round = 0; round < 50; round++) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
            } else if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

    private static LinkedHashSet<Integer> getPlayersNumbers(Scanner scanner) {
        LinkedHashSet<Integer> player = new LinkedHashSet<>();
        for (int i = 0; i < 20; i++) {
            player.add(scanner.nextInt());

        }

        return player;
    }
}
