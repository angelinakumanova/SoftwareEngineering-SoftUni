package SetsAndMaps.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String continent = info[0];
            String country = info[1];
            String city = info[2];

            if (!continents.containsKey(continent)) {
                continents.put(continent, new LinkedHashMap<>());
                continents.get(continent).put(country, new ArrayList<>());
                continents.get(continent).get(country).add(city);
            } else {
                if (!continents.get(continent).containsKey(country)) {
                    continents.get(continent).put(country, new ArrayList<>());
                    continents.get(continent).get(country).add(city);
                } else {
                    continents.get(continent).get(country).add(city);
                }
            }
        }

        for(Map.Entry<String, Map<String, List<String>>> continent : continents.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());
            continent.getValue().forEach((key, value) -> {
                System.out.printf("  %s -> ", key);
                System.out.print(String.join(", ", value));
                System.out.println();
            });

        }


    }
}
