package Exams.Exam_15Aug23.BusinessLogic.handball.entities.gameplay;

import Exams.Exam_15Aug23.BusinessLogic.handball.entities.team.Team;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.equipment.Equipment;

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
