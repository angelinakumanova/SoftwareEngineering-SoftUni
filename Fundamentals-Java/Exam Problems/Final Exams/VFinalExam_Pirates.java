package ExamProblems.FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VFinalExam_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, Integer> townsPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> townsGold = new LinkedHashMap<>();
        while (!command.equals("Sail")) {
            String[] tokens = command.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!townsPopulation.containsKey(city)) {
                townsPopulation.put(city, population);
                townsGold.put(city, gold);
            } else {
                townsPopulation.put(city, townsPopulation.get(city) + population);
                townsGold.put(city, townsGold.get(city) + gold);
            }

            command = scanner.nextLine();
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("=>");
            if (tokens[0].equals("Plunder")) {
                String town = tokens[1];
                int stolenPopulation = Integer.parseInt(tokens[2]);
                int stolenGold = Integer.parseInt(tokens[3]);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                        town,
                        stolenGold,
                        stolenPopulation);
                townsPopulation.put(town, townsPopulation.get(town) - stolenPopulation);
                townsGold.put(town, townsGold.get(town) - stolenGold);
                if (townsPopulation.get(town) <= 0 || townsGold.get(town) <= 0) {
                    System.out.printf("%s has been wiped off the map!\n", town);
                    townsGold.remove(town);
                    townsPopulation.remove(town);
                }
            } else if (tokens[0].equals("Prosper")) {
                String town = tokens[1];
                int gold = Integer.parseInt(tokens[2]);

                if (gold >= 0) {
                    townsGold.put(town, townsGold.get(town) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                            gold,
                            town,
                            townsGold.get(town));
                } else {
                    System.out.println("Gold added cannot be a negative number!");
                }
            }

            input = scanner.nextLine();
        }

        if (!townsPopulation.isEmpty()) {
            System.out.println("Ahoy, Captain! There are " + townsPopulation.size() + " wealthy settlements to go to:");
            for (Map.Entry<String,Integer> town : townsPopulation.entrySet()) {
                for (Map.Entry<String,Integer> entry : townsGold.entrySet()) {
                    if (entry.getKey().equals(town.getKey())) {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                                town.getKey(),
                                town.getValue(),
                                entry.getValue());
                    }
                }
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
