package Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.repositories;

import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.races.Race;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }
    @Override
    public Race getByName(String name) {
        return this.races.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }

    @Override
    public void add(Race race) {
        this.races.add(race);
    }

    @Override
    public boolean remove(Race race) {
        if (this.races.contains(race)) {
            this.races.remove(race);
            return true;
        }
        return false;
    }
}
