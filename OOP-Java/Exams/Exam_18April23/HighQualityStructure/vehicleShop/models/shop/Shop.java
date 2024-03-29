package Exams.Exam_18April23.HighQualityStructure.vehicleShop.models.shop;

import Exams.Exam_18April23.HighQualityStructure.vehicleShop.models.vehicle.Vehicle;
import Exams.Exam_18April23.HighQualityStructure.vehicleShop.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
