package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diving;

import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver.Diver;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving {
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> site = divingSite.getSeaCreatures();

        for (Diver diver : divers) {
            while (diver.canDive() && site.iterator().hasNext()) {
                diver.shoot();
                String currentCreature = site.iterator().next();

                diver.getSeaCatch().getSeaCreatures().add(currentCreature);
                site.remove(currentCreature);
            }
        }
    }
}
