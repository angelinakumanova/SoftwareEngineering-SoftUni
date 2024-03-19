package Exams.Exam_8April23.HighQualityStructure.robotService.entities.services;

import Exams.Exam_8April23.HighQualityStructure.robotService.entities.robot.Robot;
import Exams.Exam_8April23.HighQualityStructure.robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(this.robots);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements);
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.robots.size() >= this.capacity) {
            throw new IllegalStateException("Not enough capacity for this robot.");
        }
        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : this.robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        return this.supplements.stream().mapToInt(Supplement::getHardness).sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());
        sb.append("Robots: ")
                .append(this.robots.isEmpty() ?
                        "none" :
                        this.robots.stream().map(Robot::getName).collect(Collectors.joining(" ")))
                .append(System.lineSeparator());
        sb.append("Supplements: ").append(this.supplements.size()).append(" Hardness: ").append(sumHardness());

        return sb.toString();
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
