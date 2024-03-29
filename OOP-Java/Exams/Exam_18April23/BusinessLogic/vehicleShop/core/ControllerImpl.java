package Exams.Exam_18April23.BusinessLogic.vehicleShop.core;

import Exams.Exam_18April23.BusinessLogic.vehicleShop.common.ConstantMessages;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.common.ExceptionMessages;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.shop.ShopImpl;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.tool.ToolImpl;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.vehicle.VehicleImpl;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.repositories.VehicleRepository;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.repositories.WorkerRepository;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.shop.Shop;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.tool.Tool;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.vehicle.Vehicle;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.worker.FirstShift;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.worker.SecondShift;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.worker.Worker;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private VehicleRepository vehicleRepository;
    private WorkerRepository workerRepository;

    public ControllerImpl() {
        this.vehicleRepository = new VehicleRepository();
        this.workerRepository = new WorkerRepository();

    }
    @Override
    public String addWorker(String type, String workerName) {
        if (type.equals("FirstShift")) {
            this.workerRepository.add(new FirstShift(workerName));
        } else if (type.equals("SecondShift")) {
            this.workerRepository.add(new SecondShift(workerName));
        } else {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        this.vehicleRepository.add(new VehicleImpl(vehicleName, strengthRequired));
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = this.workerRepository.findByName(workerName);

        if (worker == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        worker.addTool(new ToolImpl(power));
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Vehicle vehicle = this.vehicleRepository.findByName(vehicleName);
        List<Worker> suitableWorkers = this.workerRepository.getWorkers().stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());

        if (suitableWorkers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        int countBrokenTools = 0;
        for (Worker worker : suitableWorkers) {
            Shop shop = new ShopImpl();
            shop.make(vehicle, worker);

            countBrokenTools += worker.getTools().stream().filter(Tool::isUnfit).collect(Collectors.toList()).size();
        }


        return String.format(ConstantMessages.VEHICLE_DONE + ConstantMessages.COUNT_BROKEN_INSTRUMENTS,
                vehicleName,
                vehicle.reached() ? "done" : "not done",
                countBrokenTools);
    }

    @Override
    public String statistics() {
        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format("%s vehicles are ready!",
                this.vehicleRepository.getWorkers()
                        .stream()
                        .filter(Vehicle::reached)
                        .collect(Collectors.toList())
                        .size()))
                .append(System.lineSeparator());

        statistics.append("Info for workers:").append(System.lineSeparator());
        for (Worker worker : this.workerRepository.getWorkers()) {
            statistics.append(String.format("Name: %s, Strength: %d",
                    worker.getName(),
                    worker.getStrength()))
                    .append(System.lineSeparator());
            statistics.append(String.format("Tools: %d fit left",
                    worker.getTools().stream().filter(t -> !t.isUnfit()).collect(Collectors.toList()).size()))
                    .append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}
