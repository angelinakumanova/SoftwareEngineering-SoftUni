package Exams.Exam_19Dec22.HighQualityStructure.magicGame.repositories;

import Exams.Exam_19Dec22.HighQualityStructure.magicGame.models.magics.Magic;
import Exams.Exam_19Dec22.HighQualityStructure.magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private List<Magic> magics;

    public MagicRepositoryImpl() {
        this.magics = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return Collections.unmodifiableCollection(this.magics);
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        this.magics.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        Magic searchedMagic = magics.stream().
                filter(m -> m.getName().equals(magic.getName()))
                .findFirst()
                .orElse(null);

        if (searchedMagic == null) {
            return false;
        } else {
            this.magics.remove(magic);
            return true;
        }
    }

    @Override
    public Magic findByName(String name) {
        return this.magics.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
