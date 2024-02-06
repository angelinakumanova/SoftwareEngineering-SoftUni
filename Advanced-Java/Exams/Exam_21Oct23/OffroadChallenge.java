package Exams.Exam_21Oct23;

import java.util.*;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> initialFuel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(initialFuel::push);

        Deque<Integer> additionalConsumption = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(additionalConsumption::offer);

        Deque<Integer> fuelNeeded = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(fuelNeeded::offer);

        int countAltitudes = 1;
        List<String> reachedAltitudes = new ArrayList<>();
        while (true) {

            if (reachedAltitudes.size() == 4) {
                break;
            }

            int currentFuel = initialFuel.pop();
            int currentConsumption = additionalConsumption.poll();
            int currentNeededFuel = fuelNeeded.poll();

            if (currentFuel - currentConsumption < currentNeededFuel) {
                System.out.printf("John did not reach: Altitude %d%n", countAltitudes);
                break;
            } else {
                System.out.printf("John has reached: Altitude %d%n", countAltitudes);
                reachedAltitudes.add("Altitude " + countAltitudes);
            }

            countAltitudes++;
        }

        if (!reachedAltitudes.isEmpty() && reachedAltitudes.size() < 4) {
            System.out.println("John failed to reach the top.");
            System.out.printf("Reached altitudes: %s%n", String.join(", ", reachedAltitudes));
        } else if (reachedAltitudes.isEmpty()) {
            System.out.println("John failed to reach the top.\n" +
                    "John didn't reach any altitude.");
        } else if (reachedAltitudes.size() == 4){
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}
