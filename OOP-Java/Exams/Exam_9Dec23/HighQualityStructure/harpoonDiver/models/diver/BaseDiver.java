package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.diver;

import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.seaCatch.BaseSeaCatch;
import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.seaCatch.SeaCatch;

import static Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;
import static Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.common.ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO;

public class BaseDiver implements Diver {
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return seaCatch;
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }


    @Override
    public void shoot() {
        this.oxygen -= 30;
        if (this.oxygen < 0) {
            this.oxygen = 0;
        }
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }
}
