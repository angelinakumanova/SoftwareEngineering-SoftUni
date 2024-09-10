package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VIMidExam_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> warship = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maximumHealthCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            if (input.contains("Fire")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int damage = Integer.parseInt(input.split(" ")[2]);

                if (index >= 0 && index < warship.size()) {
                    int section = warship.get(index);
                    section -= damage;
                    warship.set(index, section);
                    if (section <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            } else if (input.contains("Defend")) {
                int startIndex = Integer.parseInt(input.split(" ")[1]);
                int endIndex = Integer.parseInt(input.split(" ")[2]);
                int damage = Integer.parseInt(input.split(" ")[3]);

                if (startIndex >= 0 && startIndex < pirateShip.size() && endIndex >= 0 && endIndex < pirateShip.size()) {
                    for (int i = startIndex; i <= endIndex ; i++) {
                        int section = pirateShip.get(i);
                        section -= damage;
                        pirateShip.set(i, section);
                        if (section <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }
            } else if (input.contains("Repair")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int health = Integer.parseInt(input.split(" ")[2]);

                if (index >= 0 && index < pirateShip.size()) {
                    int section = pirateShip.get(index);
                    if (section + health > maximumHealthCapacity) {
                        section = maximumHealthCapacity;
                        pirateShip.set(index, section);
                    } else {
                        section += health;
                        pirateShip.set(index, section);
                    }
                }
            } else if (input.equals("Status")) {
                double percentage = maximumHealthCapacity * 0.2;
                int countSections = 0;
                for (int i = 0; i < pirateShip.size(); i++) {
                    if (pirateShip.get(i) < percentage) {
                        countSections++;
                    }
                }
                System.out.printf("%d sections need repair.%n", countSections);
            }

            input = scanner.nextLine();
        }

        int pirateShipSum = 0;
        for (int section: pirateShip) {
            pirateShipSum += section;
        }

        int warshipSum = 0;
        for (int section : warship) {
            warshipSum += section;
        }

        System.out.printf("Pirate ship status: %d%n", pirateShipSum);
        System.out.printf("Warship status: %d%n", warshipSum);
    }
}
