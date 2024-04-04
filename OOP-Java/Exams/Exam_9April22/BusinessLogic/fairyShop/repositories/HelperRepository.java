package Exams.Exam_9April22.BusinessLogic.fairyShop.repositories;

import Exams.Exam_9April22.BusinessLogic.fairyShop.models.Helper;

import java.util.*;

public class HelperRepository implements Repository<Helper>  {
    private Map<String, Helper> helpers;

    public HelperRepository() {
        this.helpers = new LinkedHashMap<>();
    }
    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableMap(this.helpers).values();
    }

    @Override
    public void add(Helper helper) {
        this.helpers.put(helper.getName(), helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return this.helpers.remove(helper.getName(), helper);
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.get(name);
    }
}
