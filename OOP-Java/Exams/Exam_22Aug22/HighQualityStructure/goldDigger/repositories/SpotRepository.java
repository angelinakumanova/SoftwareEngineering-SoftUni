package Exams.Exam_22Aug22.HighQualityStructure.goldDigger.repositories;

import Exams.Exam_22Aug22.HighQualityStructure.goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SpotRepository implements Repository<Spot> {
    private List<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }
    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(this.spots);
    }

    @Override
    public void add(Spot spot) {
        this.spots.add(spot);
    }

    @Override
    public boolean remove(Spot spot) {
        if (this.spots.contains(spot)) {
            this.spots.remove(spot);
            return true;
        }
        return false;
    }

    @Override
    public Spot byName(String name) {
        return this.spots.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
