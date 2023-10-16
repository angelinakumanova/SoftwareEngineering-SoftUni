package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VMidExam_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {

            if (command.contains("Collect")) {
                String item = command.split(" ")[2];
                if (!existsInList(items, item)) {
                    items.add(item);
                }
            } else if (command.contains("Drop")) {
                String item = command.split(" ")[2];
                if(existsInList(items, item)) {
                    items.remove(item);
                }
            } else if (command.contains("Combine Items")) {
                String itemsToSwitch = command.split(" ")[3];
                String oldItem = itemsToSwitch.split(":")[0];
                String newItem = itemsToSwitch.split(":")[1];
                if (existsInList(items, oldItem)) {
                    items.add(items.indexOf(oldItem) + 1, newItem);
                }
            } else if (command.contains("Renew")) {
                String item = command.split(" ")[2];

                if (existsInList(items, item)) {
                    items.remove(item);
                    items.add(item);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", items));
    }

    public static boolean existsInList (List<String> items, String item) {
        boolean existsInList = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                existsInList = true;
                break;
            }
        }

        return existsInList;
    }
}
