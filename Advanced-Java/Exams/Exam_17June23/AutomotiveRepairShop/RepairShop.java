package Exams.Exam_17June23.AutomotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        Vehicle vehicle = this.vehicles.stream().filter(e -> e.getVIN().equals(vin)).findFirst().orElse(null);
        if (vehicle != null) {
            this.vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return this.vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).get();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());
        for (Vehicle vehicle : this.vehicles) {
            sb.append(vehicle).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
