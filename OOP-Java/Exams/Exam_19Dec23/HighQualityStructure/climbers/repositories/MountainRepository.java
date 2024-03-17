package Exams.Exam_19Dec23.HighQualityStructure.climbers.repositories;

import Exams.Exam_19Dec23.HighQualityStructure.climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;

public class MountainRepository implements Repository<Mountain> {
    private Collection<Mountain> mountains;

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(mountains);
    }

    @Override
    public void add(Mountain mountain) {
        this.mountains.add(mountain);
    }

    @Override
    public boolean remove(Mountain mountain) {
        Mountain searchedMountain = this.mountains.stream()
                .filter(m -> m.getName().equals(mountain.getName()))
                .findFirst().orElse(null);
        return searchedMountain != null && this.mountains.remove(mountain);
    }

    @Override
    public Mountain byName(String name) {
        return this.mountains.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
