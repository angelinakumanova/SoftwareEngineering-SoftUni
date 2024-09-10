package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IIIMidExam_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.contains("Shoot")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int power = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index < targets.size()) {
                    int target = targets.get(index);
                    target -= power;
                    if (target <= 0) {
                        targets.remove(index);
                    } else {
                        targets.set(index, target);
                    }
                }
            } else if (command.contains("Add")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int value = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index < targets.size()) {
                    targets.add(index, value);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if (command.contains("Strike")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int radius = Integer.parseInt(command.split(" ")[2]);

                if (index == 0 || index - radius < 0 || index + radius >= targets.size()) {
                    System.out.println("Strike missed!");
                } else {
                    for (int i = index + radius; i >= index - radius; i--) {
                        targets.remove(i);
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(targets
                .toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "|"));
    }
}
