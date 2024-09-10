package Exams.Exam_18Feb23;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(textiles::offer);

        Deque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(medicaments::push);

        Map<String, Integer> healingItems = new LinkedHashMap<>();
        healingItems.put("Patch", 0);
        healingItems.put("Bandage", 0);
        healingItems.put("MedKit", 0);
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int currentTextile = textiles.peek();
            int currentMedicament = medicaments.peek();
            int sum = currentTextile + currentMedicament;

            if (sum == 30) {
                healingItems.put("Patch", healingItems.get("Patch") + 1);
                textiles.poll();
                medicaments.pop();
            } else if (sum == 40) {
                healingItems.put("Bandage", healingItems.get("Bandage") + 1);
                textiles.poll();
                medicaments.pop();
            } else if (sum >= 100) {
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
                textiles.poll();
                medicaments.pop();
                if (sum > 100) {
                    medicaments.push(medicaments.pop() + (sum - 100));
                }
            } else {
                textiles.poll();
                medicaments.push(medicaments.pop() + 10);
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        }

        healingItems.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())).filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        if (!textiles.isEmpty()) {
            System.out.printf("Textiles left: %s%n", textiles.toString().replaceAll("[]\\[]", ""));
        } else if (!medicaments.isEmpty()) {
            System.out.printf("Medicaments left: %s%n", medicaments.toString()
                    .replaceAll("[]\\[]", ""));
        }
    }
}

