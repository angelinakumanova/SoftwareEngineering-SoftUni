package Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.models.divingSite;

import java.util.ArrayList;
import java.util.Collection;

import static Exams.Exam_9Dec23.HighQualityStructure.harpoonDiver.common.ExceptionMessages.SITE_NAME_NULL_OR_EMPTY;

public class DivingSiteImpl implements DivingSite {
    private String name;
    private Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        this.setName(name);
        this.seaCreatures = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
