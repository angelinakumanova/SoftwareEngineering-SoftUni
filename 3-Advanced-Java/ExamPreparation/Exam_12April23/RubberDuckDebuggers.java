package Exams.Exam_12April23;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> programmersTime = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(programmersTime::offer);

        Deque<Integer> numberOfTasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numberOfTasks::push);

        Map<String, Integer> ducks = new LinkedHashMap<>();
        ducks.put("Darth Vader Ducky", 0);
        ducks.put("Thor Ducky", 0);
        ducks.put("Big Blue Rubber Ducky", 0);
        ducks.put("Small Yellow Rubber Ducky", 0);
        while (programmersTime.size() > 0 && numberOfTasks.size() > 0) {
            int currentTime = programmersTime.peek();
            int currentTask = numberOfTasks.peek();
            int calculatedTime = currentTime * currentTask;

            if (calculatedTime >= 0 && calculatedTime <= 60) {
                ducks.put("Darth Vader Ducky", ducks.get("Darth Vader Ducky") + 1);
                programmersTime.poll();
                numberOfTasks.pop();
            } else if (calculatedTime >= 61 && calculatedTime <= 120) {
                ducks.put("Thor Ducky", ducks.get("Thor Ducky") + 1);
                programmersTime.poll();
                numberOfTasks.pop();
            } else if (calculatedTime >= 121 && calculatedTime <= 180) {
                ducks.put("Big Blue Rubber Ducky", ducks.get("Big Blue Rubber Ducky") + 1);
                programmersTime.poll();
                numberOfTasks.pop();
            } else if (calculatedTime >= 181 && calculatedTime <= 240) {
                ducks.put("Small Yellow Rubber Ducky", ducks.get("Small Yellow Rubber Ducky") + 1);
                programmersTime.poll();
                numberOfTasks.pop();
            } else {
                programmersTime.offerLast(programmersTime.poll());
                numberOfTasks.push(numberOfTasks.poll() - 2);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        ducks.forEach((k, v) -> {
            System.out.printf("%s: %d%n", k, v);
        });
    }
}
