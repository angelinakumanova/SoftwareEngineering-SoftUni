package AssociativeArrays.MoreExercises;

import java.util.*;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> dwarves = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {
            String[] tokens = input.split(" <:> ");
            String name = tokens[0];
            String hatColor = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            String ID = name + ":" + hatColor;
            if (!dwarves.containsKey(ID)) {
                dwarves.put(ID, physics);
            } else {
                dwarves.put(ID, Math.max(dwarves.get(ID), physics));
            }

            input = scanner.nextLine();
        }

        List<Map.Entry<String, Integer>> sortedDwarfs = new ArrayList<>(dwarves.entrySet());

        Collections.sort(sortedDwarfs, (dwarf1, dwarf2) -> {
            int compare = dwarf2.getValue().compareTo(dwarf1.getValue());
            if (compare != 0) {
                return compare;
            }

            String key1 = dwarf1.getKey().split(":")[1];
            String key2 = dwarf2.getKey().split(":")[1];

            int count1 = (int) dwarves.entrySet().stream()
                    .filter(e -> e.getKey().split(":")[1].equals(key1))
                    .count();

            int count2 = (int) dwarves.entrySet().stream()
                    .filter(e -> e.getKey().split(":")[1].equals(key2))
                    .count();

            return Integer.compare(count2, count1);
        });

        for (Map.Entry<String, Integer> dwarf : sortedDwarfs) {
            System.out.printf("(%s) %s <-> %d%n",
                    dwarf.getKey().split(":")[1],
                    dwarf.getKey().split(":")[0],
                    dwarf.getValue());
        }


    }

}
