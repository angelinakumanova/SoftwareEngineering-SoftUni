package Exams.Exam_14Aug22.BusinessLogic.football.core;


import Exams.Exam_14Aug22.BusinessLogic.football.common.ConstantMessages;
import Exams.Exam_14Aug22.BusinessLogic.football.common.ExceptionMessages;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.field.ArtificialTurf;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.field.Field;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.field.NaturalGrass;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.player.Men;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.player.Player;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.player.Women;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.supplement.Liquid;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.supplement.Powdered;
import Exams.Exam_14Aug22.BusinessLogic.football.entities.supplement.Supplement;
import Exams.Exam_14Aug22.BusinessLogic.football.repositories.SupplementRepository;
import Exams.Exam_14Aug22.BusinessLogic.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if (fieldType.equals("ArtificialTurf")) {
            this.fields.add(new ArtificialTurf(fieldName));
        } else if (fieldType.equals("NaturalGrass")) {
            this.fields.add(new NaturalGrass(fieldName));
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if (type.equals("Powdered")) {
            this.supplementRepository.add(new Powdered());
        } else if (type.equals("Liquid")) {
            this.supplementRepository.add(new Liquid());
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.supplementRepository.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        field.addSupplement(supplement);
        this.supplementRepository.remove(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        if (playerType.equals("Men")) {
            if (field.getClass().getSimpleName().equals("NaturalGrass")) {
                field.addPlayer(new Men(playerName, nationality, strength));
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
            }
        } else if (playerType.equals("Women")) {
            if (field.getClass().getSimpleName().equals("ArtificialTurf")) {
                field.addPlayer(new Women(playerName, nationality, strength));
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
            }
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        return ConstantMessages.FIELD_NOT_SUITABLE;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        field.drag();

        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        int sumOfPlayersStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, sumOfPlayersStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        for (Field field : this.fields) {
            statistics.append(field.getInfo()).append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}
