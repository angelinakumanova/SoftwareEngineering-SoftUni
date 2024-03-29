package Exams.Exam_18April23.BusinessLogic.vehicleShop.models.shop;

import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.tool.Tool;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.vehicle.Vehicle;
import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop{
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();
        for (Tool tool : tools) {
            while (worker.canWork() && !tool.isUnfit() && !vehicle.reached()) {
                worker.working();
                tool.decreasesPower();
                vehicle.making();
            }
        }
    }
}
