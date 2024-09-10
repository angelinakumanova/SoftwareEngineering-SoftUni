package Exams.Exam_19Dec23.HighQualityStructure.climbers.repositories;

import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.climber.Climber;

import java.util.Collection;
import java.util.Collections;

public class ClimberRepository implements Repository<Climber> {
    private Collection<Climber> climbers;
    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(this.climbers);
    }

    @Override
    public void add(Climber climber) {
        this.climbers.add(climber);
    }

    @Override
    public boolean remove(Climber climber) {
        Climber searchedClimber = this.climbers.stream()
                .filter(c -> c.getName().equals(climber.getName()))
                .findFirst().orElse(null);
        return searchedClimber != null && this.climbers.remove(climber);
    }

    @Override
    public Climber byName(String name) {
        return this.climbers.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }
}
