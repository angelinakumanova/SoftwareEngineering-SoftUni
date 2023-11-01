package AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                if (!materials.containsKey(material)) {
                    materials.put(material, quantity);
                } else {
                    materials.put(material, materials.get(material) + quantity);
                }

                if (materials.get(material) >= 250) {
                    if (material.equals("shards")) {
                        materials.put(material, materials.get(material) - 250);
                        System.out.println("Shadowmourne obtained!");
                        printLeftMaterials(materials);
                        return;
                    } else if (material.equals("fragments")) {
                        materials.put(material, materials.get(material) - 250);
                        System.out.println("Valanyr obtained!");
                        printLeftMaterials(materials);
                        return;
                    } else if (material.equals("motes")) {
                        materials.put(material, materials.get(material) - 250);
                        System.out.println("Dragonwrath obtained!");
                        printLeftMaterials(materials);
                        return;
                    }
                }

                i += 1;
            }
        }
    }

    public static void printLeftMaterials(LinkedHashMap<String, Integer> materials) {
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
