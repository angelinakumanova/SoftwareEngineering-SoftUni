package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.repositories;

import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.diver.Diver;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiverRepository implements Repository<Diver> {
    private Map<String, Diver> divers;

    public DiverRepository() {
        this.divers = new LinkedHashMap<>();
    }


    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableMap(this.divers).values();
    }

    @Override
    public void add(Diver diver) {
        this.divers.put(diver.getName(), diver);
    }

    @Override
    public boolean remove(Diver diver) {
        return this.divers.remove(diver.getName(), diver);
    }

    @Override
    public Diver byName(String name) {
        return this.divers.get(name);
    }
}
