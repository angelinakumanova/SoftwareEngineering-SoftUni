package Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber;

import Exams.Exam_19Dec23.BusinessLogic.climbers.models.roster.Roster;
import Exams.Exam_19Dec23.BusinessLogic.climbers.models.roster.RosterImpl;

import static Exams.Exam_19Dec23.BusinessLogic.climbers.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static Exams.Exam_19Dec23.BusinessLogic.climbers.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseClimber implements Climber{

    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        this.setName(name);
        this.setStrength(strength);
        roster = new RosterImpl();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        return strength > 0;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }

    @Override
    public abstract void climb();
    public void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


}
