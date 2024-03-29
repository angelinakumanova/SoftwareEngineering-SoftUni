package Exams.Exam_18April23.BusinessLogic.vehicleShop.repositories;

import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.vehicle.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleRepository implements Repository<Vehicle> {

    private Map<String, Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new LinkedHashMap<>();
    }
    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableMap(this.vehicles).values();
    }

    @Override
    public void add(Vehicle vehicle) {
        this.vehicles.put(vehicle.getName(), vehicle);
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return vehicles.remove(vehicle.getName(), vehicle);
    }

    @Override
    public Vehicle findByName(String name) {
        return vehicles.get(name);
    }
}
