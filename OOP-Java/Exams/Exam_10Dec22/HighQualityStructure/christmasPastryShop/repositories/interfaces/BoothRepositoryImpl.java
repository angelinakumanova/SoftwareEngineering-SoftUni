package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces;

import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Map<Integer, Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new LinkedHashMap<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return this.booths.get(number);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableMap(this.booths).values();
    }

    @Override
    public void add(Booth booth) {
        this.booths.put(booth.getBoothNumber(), booth);
    }
}
