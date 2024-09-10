package SetsAndMaps.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        while (true) {
            String[] materials = scanner.nextLine().split("\\s+");
            for (int pos = 0; pos < materials.length; pos++) {
                String material = materials[pos + 1].toLowerCase();
                int value = Integer.parseInt(materials[pos]);

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + value);
                    if (keyMaterials.get(material) >= 250) {
                        System.out.println(getLegendaryItem(material));
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        printTheLeftMaterials(keyMaterials, junkMaterials);
                        return;
                    }
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, value);
                    } else {
                        junkMaterials.put(material, junkMaterials.get(material) + value);
                    }
                }

                pos += 1;
            }
        }
    }

    private static String getLegendaryItem (String material) {
        if (material.equals("shards")) {
            return "Shadowmourne obtained!";
        } else if (material.equals("fragments")) {
            return "Valanyr obtained!";
        }
        return "Dragonwrath obtained!";
    }

    private static void printTheLeftMaterials (Map<String, Integer> keyMaterials, Map<String, Integer> junkMaterials) {
        LinkedHashMap<String, Integer> keyMaterialsSorted = sortKeyMaterials(keyMaterials);
        for (String material : keyMaterialsSorted.keySet()) {
            System.out.printf("%s: %d%n", material, keyMaterials.get(material));
        }

        for (Map.Entry<String, Integer> junkMaterial : junkMaterials.entrySet()) {
            System.out.printf("%s: %d%n", junkMaterial.getKey(), junkMaterial.getValue());
        }
    }

    private static LinkedHashMap<String, Integer> sortKeyMaterials (Map<String, Integer> keyMaterials) {
        LinkedHashMap<String, Integer> sortedKeyMaterials = keyMaterials.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    int valueComparison = Integer.compare(entry2.getValue(), entry1.getValue());
                    if (valueComparison != 0) {
                        return valueComparison;
                    }
                    return entry1.getKey().compareTo(entry2.getKey());
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        return sortedKeyMaterials;
    }
}
