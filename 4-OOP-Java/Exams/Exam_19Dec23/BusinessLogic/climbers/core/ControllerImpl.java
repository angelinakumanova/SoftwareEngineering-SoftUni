package Exams.Exam_19Dec23.BusinessLogic.climbers.core;

import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber.Climber;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber.RockClimber;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber.WallClimber;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climbing.Climbing;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climbing.ClimbingImpl;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.mountain.Mountain;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.mountain.MountainImpl;
import Exams.Exam_19Dec23.BusinessLogic.climbers.repositories.ClimberRepository;
import Exams.Exam_19Dec23.BusinessLogic.climbers.repositories.MountainRepository;
import Exams.Exam_19Dec23.BusinessLogic.climbers.repositories.Repository;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

import static Exams.Exam_19Dec23.BusinessLogic.climbers.common.ConstantMessages.PEAK_CLIMBING;
import static Exams.Exam_19Dec23.BusinessLogic.climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    Repository<Climber> climberRepository;
    Repository<Mountain> mountainRepository;
    int countMountains;

    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
        this.countMountains = 0;
    }

    @Override
    public String addClimber(String type, String climberName) {
        if (type.equals("WallClimber")) {
            climberRepository.add(new WallClimber(climberName));
        } else if (type.equals("RockClimber")) {
            climberRepository.add(new RockClimber(climberName));
        } else {
            throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }
        return String.format("Added %s: %s.", type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        mountainRepository.add(mountain);
        mountain.getPeaksList().addAll(List.of(peaks));
        return String.format("Added Mountain: %s.", mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = climberRepository.byName(climberName);
        if (climber == null) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }
        climberRepository.remove(climber);
        return String.format("Climber %s was removed!", climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = this.climberRepository.getCollection();
        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }

        Mountain mountain = this.mountainRepository.byName(mountainName);
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);
        int removedClimbers = 0;
        for (Climber climber : climbers) {
            if (climber.getStrength() == 0) {
                removedClimbers++;
            }
        }
        this.countMountains++;
        return String.format(PEAK_CLIMBING, mountainName, removedClimbers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d mountain/s was/were climbed.%n", countMountains));
        sb.append("Climber's statistics:").append(System.lineSeparator());

        DecimalFormat df = new DecimalFormat("0.##");
        for (Climber climber : climberRepository.getCollection()) {
            sb.append("Name: ").append(climber.getName()).append(System.lineSeparator());
            sb.append("Strength: ").append(df.format(climber.getStrength())).append(System.lineSeparator());

            Collection<String> peaks = climber.getRoster().getPeaks();
            sb.append("Conquered peaks: ")
                    .append(peaks.isEmpty() ? "None" : String.join(", ", peaks))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
