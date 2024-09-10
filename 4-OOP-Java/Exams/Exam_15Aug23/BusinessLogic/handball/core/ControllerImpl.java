package Exams.Exam_15Aug23.BusinessLogic.handball.core;

import Exams.Exam_15Aug23.BusinessLogic.handball.entities.equipment.ElbowPad;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.equipment.Equipment;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.equipment.Kneepad;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.gameplay.Gameplay;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.gameplay.Indoor;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.gameplay.Outdoor;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.team.Bulgaria;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.team.Germany;
import Exams.Exam_15Aug23.BusinessLogic.handball.entities.team.Team;
import Exams.Exam_15Aug23.BusinessLogic.handball.repositories.EquipmentRepository;
import Exams.Exam_15Aug23.BusinessLogic.handball.repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

import static Exams.Exam_15Aug23.BusinessLogic.handball.common.ConstantMessages.*;
import static Exams.Exam_15Aug23.BusinessLogic.handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipment;
    private Map<String, Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new LinkedHashMap<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        if ("Outdoor".equals(gameplayType)) {
            gameplays.put(gameplayName, new Outdoor(gameplayName));
        } else if ("Indoor".equals(gameplayType)) {
            gameplays.put(gameplayName, new Indoor(gameplayName));
        } else {
            throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        if ("Kneepad".equals(equipmentType)) {
            equipment.add(new Kneepad());
        } else if ("ElbowPad".equals(equipmentType)) {
            equipment.add(new ElbowPad());
        } else {
            throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment searchedEquipment = this.equipment.findByType(equipmentType);
        if (searchedEquipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }

        this.gameplays.get(gameplayName).addEquipment(searchedEquipment);
        this.equipment.remove(searchedEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Gameplay gameplay = this.gameplays.get(gameplayName);
        if ("Bulgaria".equals(teamType)) {
            if (gameplay.getClass().getSimpleName().equals("Outdoor")) {
                this.gameplays.get(gameplayName).addTeam(new Bulgaria(teamName, country, advantage));
                return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
            }
        } else if ("Germany".equals(teamType)) {
            if (gameplay.getClass().getSimpleName().equals("Indoor")) {
                this.gameplays.get(gameplayName).addTeam(new Germany(teamName, country, advantage));
                return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
            }
        } else {
            throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }

        return GAMEPLAY_NOT_SUITABLE;
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = this.gameplays.get(gameplayName);
        int count = 0;
        for (Team team : gameplay.getTeam()) {
            team.play();
            count++;
        }
        return String.format(TEAMS_PLAYED, count);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = this.gameplays.get(gameplayName);
        int totalAdvantage = 0;
        for (Team team : gameplay.getTeam()) {
            totalAdvantage += team.getAdvantage();
        }
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, totalAdvantage);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        gameplays.forEach((k,v) -> sb.append(v).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
