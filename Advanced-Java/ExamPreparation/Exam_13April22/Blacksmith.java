package ExamPreparation.Exam_13April22;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> steel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(steel::offer);

        Deque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(carbon::push);

        Map<String, Integer> forgedSwords = new TreeMap<>();
        while (!steel.isEmpty() && !carbon.isEmpty()) {

            int currentSteel = steel.peek();
            int currentCarbon = carbon.peek();
            int sum = currentSteel + currentCarbon;

            if (sum == 70) {
                forgeSword(forgedSwords, "Gladius", steel, carbon);
            } else if (sum == 80) {
                forgeSword(forgedSwords, "Shamshir", steel, carbon);
            } else if (sum == 90) {
                forgeSword(forgedSwords, "Katana", steel, carbon);
            } else if (sum == 110) {
                forgeSword(forgedSwords, "Sabre", steel, carbon);
            } else {
                steel.poll();
                carbon.push(carbon.pop() + 5);
            }
        }

        int totalSwords = forgedSwords.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(totalSwords == 0 ? "You did not have enough resources to forge a sword." :
                String.format("You have forged %d swords.", totalSwords));

        System.out.println(steel.isEmpty() ? "Steel left: none" : String.format("Steel left: %s",
                steel.toString().replaceAll("[]\\[]", "")));
        System.out.println(carbon.isEmpty() ? "Carbon left: none" : String.format("Carbon left: %s",
                carbon.toString().replaceAll("[]\\[]", "")));

        forgedSwords.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static void forgeSword(Map<String,Integer> forgedSwords, String name,
                                   Deque<Integer> steel, Deque<Integer> carbon) {
        if (!forgedSwords.containsKey(name)) {
            forgedSwords.put(name, 1);
        } else {
            forgedSwords.put(name, forgedSwords.get(name) + 1);
        }

        steel.poll();
        carbon.pop();
    }
}
