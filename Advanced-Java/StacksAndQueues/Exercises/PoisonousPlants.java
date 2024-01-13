package StacksAndQueues.Exercises;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        int[] pesticides = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> plants = new ArrayList<>();
        for (int i = 0; i < numberOfPlants; i++) {
            plants.add(pesticides[i]);
        }


        int dayCounter = 0;
        while (true) {
            boolean plantDied = false;
            for (int i = plants.size() - 1; i >= 1; i--) {
                if (plants.get(i) > plants.get(i - 1)) {
                    plants.remove(plants.get(i));
                    plantDied = true;
                }
            }

            if (!plantDied) {
                break;
            }
            dayCounter++;
        }

        System.out.println(dayCounter);


    }
}
