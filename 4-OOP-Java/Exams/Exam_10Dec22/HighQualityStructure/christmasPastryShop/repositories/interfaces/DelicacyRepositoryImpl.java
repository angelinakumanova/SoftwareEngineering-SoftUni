package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces;

import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private Map<String, Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new LinkedHashMap<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return this.delicacies.get(name);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableMap(this.delicacies).values();
    }

    @Override
    public void add(Delicacy delicacy) {
        this.delicacies.put(delicacy.getName(), delicacy);
    }
}
