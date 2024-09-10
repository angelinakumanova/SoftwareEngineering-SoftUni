package Exams.Exam_19Dec22.BusinessLogic.magicGame.core;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.BlackWidow;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.Magician;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.Wizard;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics.BlackMagic;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics.Magic;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magics.RedMagic;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.region.Region;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.region.RegionImpl;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.repositories.MagicRepositoryImpl;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.repositories.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Exams.Exam_19Dec22.BusinessLogic.magicGame.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        if (type.equals("RedMagic")) {
            magics.addMagic(new RedMagic(name, bulletsCount));
        } else if (type.equals("BlackMagic")) {
            magics.addMagic(new BlackMagic(name, bulletsCount));
        } else {
            throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }
        return String.format("Successfully added magic %s.", name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magics.findByName(magicName);
        if (magic == null) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        if (type.equals("Wizard")) {
            magicians.addMagician(new Wizard(username, health, protection, magic));
        } else if (type.equals("BlackWidow")) {
            magicians.addMagician(new BlackWidow(username, health, protection, magic));
        } else {
            throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }
        return String.format("Successfully added magician %s.", username);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        List<Magician> sortedMagicians = magicians.getData().stream()
                .sorted(Comparator.comparing(Magician::getHealth)
                        .thenComparing(Magician::getUsername)
                        .thenComparing(m -> m.getClass().getSimpleName()))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Magician magician : sortedMagicians) {
            sb.append(magician).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
