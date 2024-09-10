package Exams.Exam_14Aug22.BusinessLogic.football.entities.field;

import Exams.Exam_14Aug22.BusinessLogic.football.entities.player.Player;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static Exams.Exam_14Aug22.BusinessLogic.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static Exams.Exam_14Aug22.BusinessLogic.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : this.players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s (%s):%n", this.name, this.getClass().getSimpleName()));
        info.append(String.format("Player: %s%n", this.players.isEmpty() ? "none" :
                this.players.stream().map(Player::getName).collect(Collectors.joining(" "))));
        info.append(String.format("Supplement: %d%n", this.supplements.size()));
        info.append(String.format("Energy: %d", this.sumEnergy()));

        return info.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
