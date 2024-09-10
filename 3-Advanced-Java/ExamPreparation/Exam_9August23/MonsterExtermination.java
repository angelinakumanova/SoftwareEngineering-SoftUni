package Exams.Exam_9August23;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> monsters = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(monsters::offer);

        Deque<Integer> strengthOfStrikes = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(strengthOfStrikes::push);

        int initialMonsters = monsters.size();
        while (monsters.size() > 0 && strengthOfStrikes.size() > 0) {

            int currentMonsterArmor = monsters.peek();
            int currentSoldierStrike = strengthOfStrikes.peek();

            if (currentSoldierStrike >= currentMonsterArmor) {
                monsters.poll();
                if (currentSoldierStrike - currentMonsterArmor > 0) {
                    int decreasedStrike = currentSoldierStrike - currentMonsterArmor;
                    strengthOfStrikes.pop();
                    strengthOfStrikes.push(strengthOfStrikes.size() > 1 ?
                                    decreasedStrike + strengthOfStrikes.pop() : decreasedStrike);


                } else {
                    strengthOfStrikes.pop();
                }
            } else {
                monsters.poll();
                strengthOfStrikes.pop();
                monsters.addLast(currentMonsterArmor - currentSoldierStrike);
            }

        }

        if (monsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (strengthOfStrikes.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d%n", initialMonsters - monsters.size());
    }
}
