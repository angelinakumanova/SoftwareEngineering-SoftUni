package Exams.Exam_19Dec22.HighQualityStructure.magicGame.repositories;

import Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magicians.Magician;
import Exams.Exam_19Dec22.HighQualityStructure.magicGame.repositories.interfaces.MagicianRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private List<Magician> magicians;

    public MagicianRepositoryImpl() {
        this.magicians = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return Collections.unmodifiableCollection(this.magicians);
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        this.magicians.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        Magician searchedMagician = this.magicians.stream()
                .filter(m -> m.getUsername().equals(magician.getUsername()))
                .findFirst()
                .orElse(null);

        if (searchedMagician != null) {
            this.magicians.remove(magician);
            return true;
        }

        return false;
    }

    @Override
    public Magician findByUsername(String name) {
        return this.magicians.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}
