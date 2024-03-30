package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.repositories;

import Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DivingSiteRepository implements Repository<DivingSite> {
    private Map<String, DivingSite> sites;

    public DivingSiteRepository() {
        this.sites = new LinkedHashMap<>();
    }
    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableMap(this.sites).values();
    }

    @Override
    public void add(DivingSite divingSite) {
        this.sites.put(divingSite.getName(), divingSite);
    }

    @Override
    public boolean remove(DivingSite divingSite) {
        return this.sites.remove(divingSite.getName(), divingSite);
    }

    @Override
    public DivingSite byName(String name) {
        return this.sites.get(name);
    }
}
