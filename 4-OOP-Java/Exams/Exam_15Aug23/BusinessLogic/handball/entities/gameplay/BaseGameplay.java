package Exams.Exam_15Aug23.BusinessLogic.handball.entities.gameplay;

import Exams.Exam_15Aug23.BusinessLogic.handball.entities.equipment.Equipment;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static Exams.Exam_15Aug23.BusinessLogic.handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    @Override
    public int allProtection() {
        return equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        for (Team team : this.teams) {
            team.play();
        }
    }

    @Override
    public Collection<Team> getTeam() {
        return Collections.unmodifiableCollection(this.teams);
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return Collections.unmodifiableCollection(this.equipments);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append("Team: ")
                .append(this.teams.isEmpty() ? "none" :
                        this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")))
                .append(System.lineSeparator());

        sb.append("Equipment: ").append(this.equipments.size()).append(", ");
        sb.append("Protection: ").append(allProtection());
        return sb.toString();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


}
