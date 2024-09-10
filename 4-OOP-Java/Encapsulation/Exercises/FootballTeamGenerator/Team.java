package Encapsulation.Exercises.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Player player = this.players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player == null) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
        this.players.remove(player);
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}
