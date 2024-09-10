package ExamProblems.MidExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VIMidExam_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();


        while (!command.equals("Yohoho!")) {

            if (command.contains("Loot")) {
                String[] items = command.split(" ");

                for (int i = 1; i < items.length; i++) {
                    boolean existsInLoot = false;
                    for (int j = 0; j < initialLoot.size(); j++) {
                        if (items[i].equals(initialLoot.get(j))) {
                            existsInLoot = true;
                            break;
                        }
                    }
                    if (!existsInLoot) {
                        initialLoot.add(0, items[i]);
                    }
                }
            } else if (command.contains("Drop")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                if (index >= 0 && index < initialLoot.size()) {
                    String item = initialLoot.get(index);
                    initialLoot.remove(index);
                    initialLoot.add(item);
                }
            } else if (command.contains("Steal")) {
                List<String> stolenItems = new ArrayList<>();
                int count = Integer.parseInt(command.split(" ")[1]);
                if (count > initialLoot.size()) {
                    count = initialLoot.size();
                }
                for (int i = 0; i < count ; i++) {
                    stolenItems.add(0, initialLoot.get(initialLoot.size() - 1));
                    initialLoot.remove(initialLoot.size() - 1);
                }
                System.out.println(String.join(", ", stolenItems));
            }

            command = scanner.nextLine();
        }


        if (initialLoot.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageGain = 0;
            for (String item : initialLoot) {
                averageGain += item.length();
            }
            averageGain /= initialLoot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }

    }
}
