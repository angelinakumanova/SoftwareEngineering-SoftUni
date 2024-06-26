package Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.models.divingSite;

import Exams.Exam_9Dec23.BusinessLogic.harpoonDiver.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

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
            throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
