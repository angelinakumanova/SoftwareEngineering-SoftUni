package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.core;

import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.common.ConstantMessages;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.common.ExceptionMessages;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver.DeepWaterDiver;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver.Diver;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver.OpenWaterDiver;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diver.WreckDiver;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.diving.DivingImpl;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.divingSite.DivingSite;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.divingSite.DivingSiteImpl;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.repositories.DiverRepository;
import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.repositories.DivingSiteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DiverRepository diverRepository;
    private DivingSiteRepository divingSiteRepository;
    private int countSites;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
    }
    @Override
    public String addDiver(String kind, String diverName) {
        if (kind.equals("DeepWaterDiver")) {
            this.diverRepository.add(new DeepWaterDiver(diverName));
        } else if (kind.equals("OpenWaterDiver")) {
            this.diverRepository.add(new OpenWaterDiver(diverName));
        } else if (kind.equals("WreckDiver")) {
            this.diverRepository.add(new WreckDiver(diverName));
        } else {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }
        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        divingSite.getSeaCreatures().addAll(List.of(seaCreatures));

        this.divingSiteRepository.add(divingSite);

        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = this.diverRepository.byName(diverName);
        if (diver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }

        this.diverRepository.remove(diver);

        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> suitableDivers = this.diverRepository.getCollection().stream().filter(d -> d.getOxygen() > 30).collect(Collectors.toList());

        if (suitableDivers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }


        DivingSite divingSite = this.divingSiteRepository.byName(siteName);
        DivingImpl diving = new DivingImpl();

        diving.searching(divingSite, suitableDivers);
        countSites++;

        int removedDivers = 0;
        for (Diver diver : suitableDivers) {
            if (diver.getOxygen() <= 0) {
                removedDivers++;
            }
        }

        return String.format(ConstantMessages.SITE_DIVING, siteName, removedDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format(ConstantMessages.FINAL_DIVING_SITES, countSites)).append(System.lineSeparator());
        statistics.append(ConstantMessages.FINAL_DIVERS_STATISTICS).append(System.lineSeparator());

        for (Diver diver : this.diverRepository.getCollection()) {
            statistics.append(String.format(ConstantMessages.FINAL_DIVER_NAME, diver.getName())).append(System.lineSeparator());
            statistics.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen())).append(System.lineSeparator());
            statistics.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, diver.getSeaCatch().getSeaCreatures().isEmpty() ? "None" :
                    String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch().getSeaCreatures())))
                    .append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}
