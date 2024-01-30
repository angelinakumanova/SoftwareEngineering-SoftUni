package DefiningClasses.Exercises.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public void addBadges(Trainer trainer) {
        this.badges += 1;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public boolean containsElement(Trainer trainer, String element) {
        for (Pokemon pokemon : trainer.pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void damagePokemon(Trainer trainer) {
        for (Pokemon pokemon : trainer.pokemons) {
            pokemon.removeHealth();
        }
        pokemons.removeIf(p -> p.getHealth() <= 0);
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
