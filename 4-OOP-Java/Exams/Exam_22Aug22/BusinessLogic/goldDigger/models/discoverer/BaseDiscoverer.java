package Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer;

import Exams.Exam_22Aug22.BusinessLogic.goldDigger.common.ExceptionMessages;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.museum.BaseMuseum;
import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {
    private static final int DEFAULT_ENERGY_INSPECT = 15;
    private String name;
    private double energy;
    private Museum museum;



    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public void dig() {
        this.energy = Math.max(0, this.energy - DEFAULT_ENERGY_INSPECT);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s", this.name)).append(System.lineSeparator());
        sb.append(String.format("Energy: %.0f", this.energy)).append(System.lineSeparator());
        sb.append(String.format("Museum exhibits: %s", this.getMuseum().getExhibits().isEmpty() ? "None" :
                String.join(", ", this.getMuseum().getExhibits())));

        return sb.toString();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }


}
