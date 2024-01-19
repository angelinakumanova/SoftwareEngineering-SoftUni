package SetsAndMaps.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String regex = "(?<name>([A-Za-z]+\\s)+)@(?<place>([A-Za-z]+\\s)+)(?<price>\\d+)\\s(?<count>\\d+)";
        Pattern pat = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Matcher mat = pat.matcher(input);

            if (mat.find()) {
                String singer = mat.group("name").trim();
                String place = mat.group("place").trim();
                int priceOfTicket = Integer.parseInt(mat.group("price"));
                int amountOfTickets = Integer.parseInt(mat.group("count"));

                venues.putIfAbsent(place, new LinkedHashMap<>());
                if (!venues.get(place).containsKey(singer)) {
                    venues.get(place).put(singer, priceOfTicket * amountOfTickets);
                } else {
                    venues.get(place).put(singer, venues.get(place).get(singer) + (priceOfTicket * amountOfTickets));
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> venue : venues.entrySet()) {
            System.out.println(venue.getKey());
            venue.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach((entry) -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
        }
    }
}

