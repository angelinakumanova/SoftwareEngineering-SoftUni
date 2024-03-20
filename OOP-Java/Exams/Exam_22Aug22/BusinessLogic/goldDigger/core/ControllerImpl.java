package Exams.Exam_22Aug22.BusinessLogic.goldDigger.core;

import Exams.Exam_22Aug22.BusinessLogic.goldDigger.common.ConstantMessages;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.common.ExceptionMessages;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Anthropologist;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Archaeologist;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Discoverer;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Geologist;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.operation.Operation;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.operation.OperationImpl;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.spot.Spot;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.spot.SpotImpl;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.repositories.DiscovererRepository;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int inspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.inspectedSpots = 0;
    }
    @Override
    public String addDiscoverer(String kind, String discovererName) {
        if (kind.equals("Anthropologist")) {
            this.discovererRepository.add(new Anthropologist(discovererName));
        } else if (kind.equals("Archaeologist")) {
            this.discovererRepository.add(new Archaeologist(discovererName));
        } else if (kind.equals("Geologist")) {
            this.discovererRepository.add(new Geologist(discovererName));
        } else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        this.spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        this.discovererRepository.remove(discoverer);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discoverers = this.discovererRepository.getCollection().stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());
        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = this.spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, discoverers);

        long excluded = discoverers.stream().filter(d -> d.getEnergy() == 0).count();

        this.inspectedSpots++;
        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded);
    }


    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d spots were inspected.", inspectedSpots)).append(System.lineSeparator());
        sb.append("Information for the discoverers:").append(System.lineSeparator());
        for (Discoverer discoverer : this.discovererRepository.getCollection()) {
            sb.append(discoverer).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
