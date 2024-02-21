package WorkingWithAbstraction.Exercises.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        System.out.printf("Card name: %s of %s; Card power: %d%n",
                rank,
                suit,
                Enum.valueOf(Rank.class, rank).getValue() + Enum.valueOf(Suit.class, suit).getValue());
    }
}
