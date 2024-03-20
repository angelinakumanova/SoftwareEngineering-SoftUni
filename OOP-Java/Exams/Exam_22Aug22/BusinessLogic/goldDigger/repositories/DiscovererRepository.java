package Exams.Exam_22Aug22.BusinessLogic.goldDigger.repositories;

import Exams.Exam_22Aug22.BusinessLogic.goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiscovererRepository implements Repository<Discoverer> {
    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }
    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers);
    }

    @Override
    public void add(Discoverer discoverer) {
        this.discoverers.add(discoverer);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        if (this.discoverers.contains(discoverer)) {
            this.discoverers.remove(discoverer);
            return true;
        }
        return false;
    }

    @Override
    public Discoverer byName(String name) {
        return this.discoverers.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
