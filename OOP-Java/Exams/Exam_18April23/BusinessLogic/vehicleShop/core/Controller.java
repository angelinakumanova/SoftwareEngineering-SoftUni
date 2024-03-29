package Exams.Exam_18April23.BusinessLogic.vehicleShop.core;

public interface Controller {
    String addWorker(String type, String workerName);

    String addVehicle(String vehicleName, int strengthRequired);

    String addToolToWorker(String workerName, int power);

    String makingVehicle(String vehicleName);

    String statistics();
}
