package Exams.Exam_18April23.BusinessLogic.vehicleShop.repositories;

import Exams.Exam_18April23.BusinessLogic.vehicleShop.models.worker.Worker;

import java.util.*;

public class WorkerRepository implements Repository<Worker> {
    private Map<String, Worker> workers;

    public WorkerRepository() {
        this.workers = new LinkedHashMap<>();
    }
    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableMap(this.workers).values();
    }

    @Override
    public void add(Worker worker) {
        this.workers.put(worker.getName(), worker);
    }

    @Override
    public boolean remove(Worker worker) {
        return workers.remove(worker.getName(), worker);
    }

    @Override
    public Worker findByName(String name) {
        return this.workers.get(name);
    }
}
