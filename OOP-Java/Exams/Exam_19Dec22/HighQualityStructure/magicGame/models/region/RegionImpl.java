package Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.region;

import Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magicians.BlackWidow;
import Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magicians.Magician;
import Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream().filter(m -> m.getClass().equals(Wizard.class)).collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream().filter(m -> m.getClass().equals(BlackWidow.class)).collect(Collectors.toList());

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            for (Magician wizard : wizards) {
                for (int i = 0; i < blackWidows.size(); i++) {
                    blackWidows.get(i).takeDamage(wizard.getMagic().fire());
                    if (!blackWidows.get(i).isAlive()) {
                        blackWidows.remove(i);
                        i--;
                    }
                }
            }
            for (Magician blackWidow : blackWidows) {
                for (int i = 0; i < wizards.size(); i++) {
                    wizards.get(i).takeDamage(blackWidow.getMagic().fire());
                    if (!wizards.get(i).isAlive()) {
                        wizards.remove(i);
                        i--;
                    }
                }
            }
        }


        return wizards.isEmpty() ? "Black widows win!" : "Wizards win!";
    }
}
