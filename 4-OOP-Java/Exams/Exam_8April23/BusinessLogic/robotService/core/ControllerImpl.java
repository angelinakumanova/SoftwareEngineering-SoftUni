package Exams.Exam_8April23.BusinessLogic.robotService.core;

import Exams.Exam_8April23.BusinessLogic.robotService.entities.robot.FemaleRobot;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.robot.MaleRobot;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.robot.Robot;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.services.MainService;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.services.SecondaryService;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.services.Service;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.supplements.MetalArmor;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.supplements.PlasticArmor;
import Exams.Exam_8April23.BusinessLogic.robotService.entities.supplements.Supplement;
import Exams.Exam_8April23.BusinessLogic.robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static Exams.Exam_8April23.BusinessLogic.robotService.common.ConstantMessages.*;
import static Exams.Exam_8April23.BusinessLogic.robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }
    @Override
    public String addService(String type, String name) {
        if ("MainService".equals(type)) {
            this.services.add(new MainService(name));
        } else if ("SecondaryService".equals(type)) {
            this.services.add(new SecondaryService(name));
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        if ("PlasticArmor".equals(type)) {
            this.supplements.addSupplement(new PlasticArmor());
        } else if ("MetalArmor".equals(type)) {
            this.supplements.addSupplement(new MetalArmor());
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
        service.addSupplement(supplement);
        this.supplements.removeSupplement(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
        if ("MaleRobot".equals(robotType)) {
            Robot maleRobot = new MaleRobot(robotName,robotKind,price);

            if (service.getClass().getSimpleName().equals("MainService")) {
                service.addRobot(maleRobot);
                return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
            }
        } else if ("FemaleRobot".equals(robotType)) {
            Robot femaleRobot = new FemaleRobot(robotName,robotKind,price);

            if (service.getClass().getSimpleName().equals("SecondaryService")) {
                service.addRobot(femaleRobot);
                return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
            }
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        return UNSUITABLE_SERVICE;
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
        int count = 0;
        for (Robot robot : service.getRobots()) {
            robot.eating();
            count++;
        }
        return String.format(FEEDING_ROBOT, count);
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
        double totalSumRobots = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double totalSumSupplements = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();

        return String.format(VALUE_SERVICE, serviceName, (totalSumSupplements + totalSumRobots));
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Service service : this.services) {
            sb.append(service.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
