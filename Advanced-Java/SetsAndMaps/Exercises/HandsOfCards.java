package SetsAndMaps.Exercises;

import java.util.*;


public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashSet<String>> playersPlaying = new LinkedHashMap<>();

        String playerInput = scanner.nextLine();
        while (!"JOKER".equals(playerInput)) {
            String[] playerInfo = playerInput.split(": ");
            String nameOfPlayer = playerInfo[0];
            String[] deck = playerInfo[1].split(",\\s+");

            if (!playersPlaying.containsKey(nameOfPlayer)) {
                playersPlaying.put(nameOfPlayer, fillSetWithCards(deck, new LinkedHashSet<>()));
            } else {
                playersPlaying.put(nameOfPlayer, fillSetWithCards(deck, playersPlaying.get(nameOfPlayer)));
            }
            playerInput = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashSet<String>> player : playersPlaying.entrySet()) {
            System.out.printf("%s: %d%n", player.getKey(), calculateValue(player.getValue()));
        }
    }

    private static LinkedHashSet<String> fillSetWithCards (String[] deck, LinkedHashSet<String> cards) {
        cards.addAll(Arrays.asList(deck));
        return cards;
    }

    private static int calculateValue (LinkedHashSet<String> cards) {
        int sum = 0;

        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String type = card.substring(card.length() - 1);
            sum += getValueOfCard(power, type);
        }
        return sum;
    }

    private static int getValueOfCard (String powerCard, String typeCard) {
        int value = 0;
        switch (powerCard) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default: value = Integer.parseInt(powerCard);
            break;
        }
        switch (typeCard) {
            case "S":
                return 4 * value;
            case "H":
                return 3 * value;
            case "D":
                return 2 * value;
            default: return value;
        }
    }
}
