package DefiningClasses.Exercises.PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            String pokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(name, new Trainer(name));
            trainers.get(name).addPokemon(new Pokemon(pokemon, element, health));

            input = scanner.nextLine();
        }

        String elementInput = scanner.nextLine();
        while (!"End".equals(elementInput)) {
            for (Trainer trainer : trainers.values()) {
                if (!trainer.getPokemons().isEmpty()) {
                    if (trainer.containsElement(trainer, elementInput)) {
                        trainer.addBadges(trainer);
                    } else {
                        trainer.damagePokemon(trainer);

                    }
                }
            }

            elementInput = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
