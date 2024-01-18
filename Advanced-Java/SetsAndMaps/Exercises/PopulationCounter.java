package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countriesAndCities = new LinkedHashMap<>();
        Map<String, Long> countriesPopulation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countriesAndCities.containsKey(country)) {
                countriesAndCities.put(country, new LinkedHashMap<>());
                countriesAndCities.get(country).put(city, population);
                countriesPopulation.put(country, population);
            } else {
                if (!countriesAndCities.get(country).containsKey(city)) {
                    countriesAndCities.get(country).put(city, population);
                    countriesPopulation.put(country, countriesPopulation.get(country) + population);
                }
            }

            input = scanner.nextLine();
        }

        List<String> sortedCountries = countriesPopulation.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        for (String country : sortedCountries) {
            System.out.printf("%s (total population: %d)%n", country, countriesPopulation.get(country));

            List<String> sortedCities = countriesAndCities.get(country).entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            for (String city : sortedCities) {
                long population = countriesAndCities.get(country).get(city);
                System.out.printf("=>%s: %d%n", city, population);
            }
        }
    }
}
