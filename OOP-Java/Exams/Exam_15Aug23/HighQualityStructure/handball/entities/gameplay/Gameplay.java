package Exams.Exam_15Aug23.HighQualityStructure.handball.entities.gameplay;

import Exams.Exam_15Aug23.HighQualityStructure.handball.entities.equipment.Equipment;
import Exams.Exam_15Aug23.HighQualityStructure.handball.entities.team.Team;

import java.util.Collection;

public interface Gameplay {
    int allProtection();

    void addTeam(Team team);

    void removeTeam(Team team);

    void addEquipment(Equipment equipment);

    void teamsInGameplay();

    Collection<Team> getTeam();

    Collection<Equipment> getEquipments();

    String getName();


}
