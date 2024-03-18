package Exams.Exam_19Dec22.BusinessLogic.magicGame.models.region;

import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.BlackWidow;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.Magician;
import Exams.Exam_19Dec22.BusinessLogic.magicGame.models.magicians.Wizard;

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
                    int attack = wizard.getMagic().fire();
                    blackWidows.get(i).takeDamage(attack);
                    if (!blackWidows.get(i).isAlive()) {
                        blackWidows.remove(i);
                        i--;
                    }
                }
            }
            for (Magician blackWidow : blackWidows) {
                for (int i = 0; i < wizards.size(); i++) {
                    int attack = blackWidow.getMagic().fire();
                    wizards.get(i).takeDamage(attack);
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
