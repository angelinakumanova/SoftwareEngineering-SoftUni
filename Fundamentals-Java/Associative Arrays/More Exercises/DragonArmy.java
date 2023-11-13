package AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    private static final int defaultHealth = 250;
    private static final int defaultDamage = 45;
    private static final int defaultArmor = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? defaultDamage : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? defaultHealth : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? defaultArmor : Integer.parseInt(tokens[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }
            if (!dragons.get(type).containsKey(name)) {
                dragons.get(type).put(name, new int[3]);
            }
            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;
        }
        for (Map.Entry<String, TreeMap<String, int[]>> types : dragons.entrySet()) {
            double[] average = calculateAverage(types.getValue());
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", types.getKey(), average[0], average[1], average[2]);

            for (Map.Entry<String, int[]> dragon : types.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragon.getKey(),
                        dragon.getValue()[0],
                        dragon.getValue()[1],
                        dragon.getValue()[2]);
            }
        }
    }

    public static double[] calculateAverage (TreeMap<String, int[]> dragons) {
        double count = dragons.size();
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmor = 0;

        for (Map.Entry<String, int[]> entry : dragons.entrySet()) {
            totalDamage += entry.getValue()[0];
            totalHealth += entry.getValue()[1];
            totalArmor += entry.getValue()[2];
        }

        return new double[] {
                totalDamage / count,
                totalHealth / count,
                totalArmor / count
        };
    }
}
