package Exams;

import java.util.*;

public class IIFinalExam_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> plantsRarity = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> plantsRatings = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            if (!plantsRarity.containsKey(tokens[0])) {
                plantsRarity.put(tokens[0], Integer.parseInt(tokens[1]));
                plantsRatings.put(tokens[0], new ArrayList<>());

            } else {
                plantsRarity.put(tokens[0], Integer.parseInt(tokens[1]));
            }
        }


        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] command = input.split(": ");
            if (command[0].contains("Rate")) {
                String[] commandParts = command[1].split(" - ");
                if (plantsRatings.containsKey(commandParts[0])) {
                    plantsRatings.get(commandParts[0]).add(Double.parseDouble(commandParts[1]));
                } else {
                    System.out.println("error");
                }
            } else if (command[0].contains("Update")) {
                String[] commandParts = command[1].split(" - ");
                if (plantsRarity.containsKey(commandParts[0])) {
                    plantsRarity.put(commandParts[0], Integer.parseInt(commandParts[1]));
                } else {
                    System.out.println("error");
                }
            } else if (command[0].contains("Reset")) {
                if (plantsRatings.containsKey(command[1])) {
                    plantsRatings.get(command[1]).clear();
                } else {
                    System.out.println("error");
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantsRarity.entrySet()) {
            for (Map.Entry<String, List<Double>> rating : plantsRatings.entrySet()) {
                if (entry.getKey().equals(rating.getKey())) {
                    double average = 0;
                    for (int i = 0; i < rating.getValue().size(); i++) {
                        average += rating.getValue().get(i);
                    }
                    average /= rating.getValue().size();
                    if (rating.getValue().size() == 0) {
                        average = 0;
                    }
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                            entry.getKey(),
                            entry.getValue(),
                            average);
                }
            }
        }
    }
}
