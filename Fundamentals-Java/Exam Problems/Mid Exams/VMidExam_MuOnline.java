package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VMidExam_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).contains("potion")) {
                int numberToHeal = Integer.parseInt(rooms.get(i).split(" ")[1]);
                if (numberToHeal + health >= 100) {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                } else {
                    health += numberToHeal;
                    System.out.printf("You healed for %d hp.%n", numberToHeal);
                }
                System.out.printf("Current health: %d hp.%n", health);
            } else if (rooms.get(i).contains("chest")) {
                int foundBitcoins = Integer.parseInt(rooms.get(i).split(" ")[1]);
                bitcoins += foundBitcoins;
                System.out.printf("You found %d bitcoins.%n", foundBitcoins);
            } else {
                String monster = rooms.get(i).split(" ")[0];
                int attackOfMonster = Integer.parseInt(rooms.get(i).split(" ")[1]);

                if (health - attackOfMonster <= 0) {
                    System.out.printf("You died! Killed by %s.%n", monster);
                    System.out.printf("Best room: %d%n", i + 1);
                    return;
                } else {
                    health -= attackOfMonster;
                    System.out.printf("You slayed %s.%n", monster);
                }
            }
        }

        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d%n", health);
    }
}
