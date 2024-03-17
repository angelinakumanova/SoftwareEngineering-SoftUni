package Exams.Exam_19Dec23.BusinessLogic.climbers.repositories;

import Exams.Exam_19Dec23.BusinessLogic.climbers.models.climber.Climber;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClimberRepository implements Repository<Climber> {
    private Map<String, Climber> climbers;

    public ClimberRepository() {
        this.climbers = new LinkedHashMap<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(climbers.values());
    }

    @Override
    public void add(Climber climber) {
        this.climbers.put(climber.getName(), climber);
    }

    @Override
    public boolean remove(Climber climber) {
        if (climbers.containsKey(climber.getName())) {
            climbers.remove(climber.getName());
            return true;
        }
        return false;
    }

    @Override
    public Climber byName(String name) {
        if (climbers.containsKey(name)) {
            return climbers.get(name);
        }
        return null;
    }
}
